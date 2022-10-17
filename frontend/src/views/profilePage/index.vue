<template>
  <div id="landingPage">
    <el-container>
      <el-header height="60px">
        <el-row>
          <el-col :span="3"
            ><div class="grid-content logo" @click="toLandingPage">
              <el-image
                style="width: 7.5rem; height: 3.8rem"
                :src="logo"
              ></el-image></div
          ></el-col>
          <el-col :span="5"
            ><div class="grid-content logo">
              <el-menu
                mode="horizontal"
                :default-active="$route.path"
                :router="true"
                background-color="#EEF0F8"
                text-color="#000000"
              >
                <el-menu-item index="/about" style="font-size: 1.2rem"
                  >About</el-menu-item
                >
                <el-menu-item index="/leaderboard" style="font-size: 1.2rem"
                  >Leaderboard</el-menu-item
                >
              </el-menu>
            </div></el-col
          >
          <el-col :span="12"><div class="grid-content"></div></el-col>
          <el-col :span="4"
            ><div class="grid-content">
              <el-menu
                class="el-menu-demo"
                mode="horizontal"
                :default-active="$route.path"
                :router="true"
                background-color="#EEF0F8"
                text-color="#000000"
              >
                <el-menu-item index="/profile" style="font-size: 1.2rem"
                  >Profile</el-menu-item
                >
                <el-menu-item
                  style="font-size: 1.2rem"
                  @click="showLoginDialog"
                  v-if="state == 'not login'"
                  >Login</el-menu-item
                >
                <el-menu-item
                  style="font-size: 1.2rem"
                  v-if="state == 'login'"
                  @click="handleCommand"
                  >Logout</el-menu-item
                >
              </el-menu>
            </div></el-col
          >
        </el-row>
      </el-header>
      <el-main style="text-align: center">
        <h3 v-if="state == 'login'" style="font-size: 40px; text-align: center;margin:1rem">
          {{ usrname }}'s submissions
        </h3>
        <h3
          v-if="state == 'not login'"
          style="font-size: 40px; text-align: center"
        >
          Please Login First
        </h3>

        <div
          v-if="state == 'login'"
          style="height: 400px; width: 90%; margin: auto"
          class="table-wrapper"
        >
          <el-button
            type="danger"
            round
            style="float: left; margin-bottom: 1rem"
            v-if="multipleSelection.length != 0"
            @click="showmessage"
            >Delete Selected Items</el-button
          >

          <el-table
            @selection-change="handleSelectionChange"
            ref="paperTable"
            empty-text="No Data"
            :data="modelListShow"
            stripe
            tooltip-effect="dark"
            style="color: #000000"
            :row-style="getRowClass"
            :header-row-style="getRowClass"
            :header-cell-style="getRowClass"
            :border="true"
          >
            <el-table-column type="selection" align="center"> </el-table-column>
            <el-table-column
              align="center"
              label="Model"
              show-overflow-tooltip
              prop="model"
            >
            </el-table-column>

            <el-table-column
              align="center"
              label="Submission Type"
              show-overflow-tooltip
              prop="submissionType"
            >
            </el-table-column>

            <el-table-column
              align="center"
              label="Task"
              show-overflow-tooltip
              prop="task"
            >
            </el-table-column>

            <el-table-column
              label="Created On"
              show-overflow-tooltip
              prop="createdOn"
              align="center"
            >
            </el-table-column>

            <el-table-column align="center" show-overflow-tooltip prop="flops">
              <template slot="header" slot-scope="scope"
                ><div>FLOPs<br />(MFLOPs)</div>
              </template>
            </el-table-column>
            <el-table-column
              label="Params (MParams)"
              show-overflow-tooltip
              prop="params"
              align="center"
            >
              <template slot="header" slot-scope="scope"
                ><div>Params<br />(MParams)</div>
              </template>
            </el-table-column>

            <el-table-column
              label="Performance"
              show-overflow-tooltip
              prop="performance"
              align="center"
            >
            </el-table-column>

            <!-- <el-table-column align="center" label="Action">
              <template slot-scope="scope">
                <i class="el-icon-delete" @click="open(scope.$index)"></i>
              </template>
            </el-table-column> -->
          </el-table>

          <Page
            :total="totalEntries"
            :current="currentPage"
            style="margin: 1rem"
            @on-change="handlePageChange"
          />
        </div> </el-main
      ><el-footer height="1.5rem" style="font-size: 0.9rem; text-align: left">
        Copyright©2021 Fudan University - All Rights Reserved.
        <el-link type="primary" href="https://txsun1997.github.io/"
          >Contact</el-link
        >
      </el-footer>
    </el-container>
    <el-dialog
      :visible.sync="dialogVisible"
      width="50%"
      :show-close="false"
      top="30vh"
    >
      <span slot="footer" class="dialog-footer">
        <el-input
          v-model="email"
          placeholder="Email"
          style="margin: 10px"
          clearable
        ></el-input>
        <el-input
          v-model="pwd"
          placeholder="Password"
          show-password
          style="margin: 10px"
        ></el-input>
        <el-input
          v-if="loginOrSignup == 'signup'"
          v-model="username"
          placeholder="Username"
          style="margin: 10px"
          clearable
        ></el-input>
        <el-button
          v-if="loginOrSignup == 'login'"
          @click="submitLogin"
          style="margin: 10px; width: 100%; color: #ffffff; background: #2b5283"
          >Login</el-button
        >
        <el-button
          v-if="loginOrSignup == 'signup'"
          type="primary"
          @click="submitSignup"
          style="margin: 10px; width: 100%; color: #ffffff; background: #2b5283"
          >Sign Up</el-button
        >
        <div
          style="margin: 10px; text-align: center"
          v-if="loginOrSignup == 'login'"
        >
          Don't have an account?
          <el-link @click="loginOrSignup = 'signup'">Sign up</el-link>
        </div>
        <div
          style="margin: 10px; text-align: center"
          v-if="loginOrSignup == 'signup'"
        >
          Already have an account?
          <el-link @click="loginOrSignup = 'login'">Login</el-link>
        </div>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { Login, Signup } from "@/api/landingPage";
import {
  GetModelByToken,
  DeleteModelById,
  DeleteModelsByIdList,
} from "@/api/profilePage";
const sha256 = require("js-sha256").sha256;
export default {
  data() {
    return {
      logo: require("../../assets/logo.png"),
      dialogVisible: false,
      email: "",
      pwd: "",
      loginOrSignup: "login",
      username: "",
      state: "not login",
      usrname: "",
      modelList: [],
      modelListShow: [],
      loading: null,
      multipleSelection: [],
      currentPage: 1,
      totalEntries: 100,
    };
  },

  methods: {
    handleSelectionChange(val) {
      this.multipleSelection = val;
      // console.log(this.multipleSelection)
    },
    deleteModelsByIdList() {
      let idlist = [];
      let submitType = [];
      for (let i = 0; i < this.multipleSelection.length; i++) {
        idlist.push(this.multipleSelection[i].id);
        submitType.push(this.multipleSelection[i].submissionType);
      }
      let data = {
        idList: idlist.toString(),
        submitTypeList: submitType.toString(),
      };
      DeleteModelsByIdList(data)
        .then((response) => {
          this.getModelByToken();
        })
        .catch((error) => {
          this.$message.error("Deletion failed!");
        });
    },
    showmessage() {
      this.$confirm(
        "This operation will permanently delete these models. Do you want to continue?",
        "Tips",
        {
          confirmButtonText: "Yes",
          cancelButtonText: "Cancle",
          type: "warning",
        }
      )
        .then(() => {
          this.deleteModelsByIdList();
          this.$message({
            type: "success",
            message: "Delete succeeded!",
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "Deletion cancelled",
          });
        });
    },
    open(index) {
      this.$confirm(
        "This operation will permanently delete the model. Do you want to continue?",
        "Tips",
        {
          confirmButtonText: "Yes",
          cancelButtonText: "Cancle",
          type: "warning",
        }
      )
        .then(() => {
          this.deleteModelById(index);
          this.$message({
            type: "success",
            message: "Delete succeeded!",
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "Deletion cancelled",
          });
        });
    },
    deleteModelById(index) {
      //console.log(123)
      //console.log(this.modelList)
      let data = {
        id: this.modelList[index].id,
        submitType: this.modelList[index].submissionType,
      };
      DeleteModelById(data)
        .then((response) => {
          //console.log("deleteModelById");
          this.getModelByToken();
        })
        .catch((error) => {
          //console.log(error);
        });
    },
    toLandingPage: function () {
      this.$router.replace("/");
    },
    showLoginDialog: function () {
      this.loginOrSignup = "login";
      this.dialogVisible = true;
    },
    submitLogin: function () {
      this.login();
    },
    submitSignup: function () {
      this.signup();
    },
    login: function () {
      let data = {
        email: this.email,
        pwd: sha256(this.pwd),
      };

      Login(data)
        .then((response) => {
          //console.log("login");
          window.localStorage.setItem("token", response.data.token);
          window.localStorage.setItem("username", response.data.username);
          this.loading = this.$loading({
            lock: true,
            text: "Loading",
            spinner: "el-icon-loading",
            background: "rgba(0, 0, 0, 0.7)",
          });
          this.state = "login";
          this.email = "";
          this.pwd = "";
          this.usrname = response.data.username;
          this.dialogVisible = false;
          this.getModelByToken();
        })
        .catch((error) => {
          //console.log(error);
          this.$message.error("Incorrect username or password.");
        });
    },
    getModelByToken() {
      if (this.state == "not login") return;
      let data = {
        token: window.localStorage.getItem("token"),
      };
      GetModelByToken(data)
        .then((response) => {
          this.modelList = [];

          for (let i = 0; i < response.data.paperList.length; i++) {
            let paper = response.data.paperList[i];
            let dataset = response.data.paperDatasetList[i];
            let models = response.data.modelList[i];
            //console.log("models")

            for (let j = 0; j < models.length; j++) {
              let obj = {
                id: models[j].modelId,
                model: paper.paperModel,
                submissionType: "Paper",
                task: dataset,
                createdOn: paper.paperTime.substring(0, 10),
                flops: models[j].modelFlops,
                params: models[j].modelParams,
                performance: models[j].modelRemark,
              };
              this.modelList.push(obj);
            }
          }

          for (let i = 0; i < response.data.submissionList.length; i++) {
            let submission = response.data.submissionList[i];
            let dataset = response.data.submissionDatasetList[i];
            let submits = response.data.submitList[i];
            for (let j = 0; j < submits.length; j++) {
              let obj = {
                id: submits[j].submitId,
                model: submission.submissionName,
                submissionType: "Test File",
                task: dataset,
                createdOn: submission.submissionTime.substring(0, 10),
                flops: submits[j].submitFlops,
                params: submits[j].submitParams,
                performance: submits[j].submitRemark,
              };
              this.modelList.push(obj);
            }
          }
          for (let m = 0; m < this.modelList.length - 1; m++) {
            for (let n = m + 1; n < this.modelList.length; n++) {
              if (this.modelList[m].createdOn < this.modelList[n].createdOn) {
                let t = this.modelList[m];
                this.modelList[m] = this.modelList[n];
                this.modelList[n] = t;
              }
            }
          }

          this.totalEntries = this.modelList.length;
          this.modelListShow = [];
          for (
            let i = (this.currentPage - 1) * 10;
            i < this.modelList.length && i < (this.currentPage - 1) * 10 + 10;
            i++
          )
            this.modelListShow.push(this.modelList[i]);
          this.loading.close();
        })
        .catch((error) => {
          //console.log(error);
        });
    },
    signup: function () {
      let data = {
        email: this.email,
        pwd: sha256(this.pwd),
        username: this.username,
      };

      Signup(data)
        .then((response) => {
          //console.log("signup");
          this.login();
          this.email = "";
          this.pwd = "";
          this.username = "";
          this.dialogVisible = false;
        })
        .catch((error) => {
          //console.log(error);
          this.$message.error("Email account already exists.");
        });
    },
    handleCommand(command) {
      this.state = "not login";
      window.localStorage.clear();
    },

    handlePageChange(page) {
      this.currentPage = page;
      this.modelListShow = [];
      for (
        let i = (this.currentPage - 1) * 10;
        i < this.totalEntries && i < (this.currentPage - 1) * 10 + 10;
        i++
      )
        this.modelListShow.push(this.modelList[i]);
    },
    getRowClass({ row, column, rowIndex, columnIndex }) {
      return "background:#13227A;color:#fff";
    },
  },

  created() {
    if (window.localStorage.getItem("token") != null) {
      this.loading = this.$loading({
        lock: true,
        text: "Loading",
        spinner: "el-icon-loading",
        background: "rgba(0, 0, 0, 0.7)",
      });
      this.state = "login";
      this.usrname = window.localStorage.getItem("username");
    } else {
      this.state = "not login";
    }

    this.getModelByToken();
  },
  mounted() {},
};
</script>

<style lang="scss" scoped>
#landingPage {
  height: 100%;
}

.el-container {
  height: 100%;
}

.login {
  cursor: pointer;
}

.signup {
  cursor: pointer;
}

.el-main {
  padding: 0;
  background-color: #ffffff;
}

.el-header {
  background-color: #eef0f8;
}

.logo {
  cursor: pointer;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.el-icon-delete {
  cursor: pointer;
}

.el-footer {
  background-color: #13227a;
  color: #ffffff;
  width: 100%;
}
</style>
