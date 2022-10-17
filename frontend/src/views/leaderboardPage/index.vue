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
        <h3 style="font-size: 50px; text-align: center">Leaderboard</h3>

        <p
          style="
            text-align: center;
            font-size: 20px;
            color: #13227a;
            margin-bottom: 5rem;
          "
        ></p>
        <div style="width: 90%; margin: auto">
          <el-tabs type="card" v-model="activeName" @tab-click="handleClick">
            <el-tab-pane label="ELUE Score" name="0"></el-tab-pane>
            <el-tab-pane label="ELUE (40M params)" name="40"></el-tab-pane>
            <el-tab-pane label="ELUE (55M params)" name="55"></el-tab-pane>
            <el-tab-pane label="ELUE (70M params)" name="70"></el-tab-pane>
            <el-tab-pane label="ELUE (110M params)" name="110"></el-tab-pane>
          </el-tabs>
          <el-table
            empty-text="No Data"
            stripe
            tooltip-effect="dark"
            :data="sentenceModelPerformanceListShow"
            :row-style="getRowClass"
            :header-row-style="getRowClass"
            :header-cell-style="getRowClass"
            :border="true"
            :default-sort="{ prop: 'average', order: 'descending' }"
          >
            <el-table-column align="center" label="Model" prop="modelName">
            </el-table-column>
            <el-table-column
              v-for="(item, index) in sentenceTask"
              :key="item.taskId"
              align="center"
            >
              <template slot="header" slot-scope="scope"
                ><span>{{ item.taskName }}</span>
              </template>
              <el-table-column
                align="center"
                v-for="item1 in datasetList[index]"
                :key="item1.datasetId"
                :prop="item1.datasetName"
              >
                <template slot="header" slot-scope="scope"
                  ><span>{{ item1.datasetName }}</span>
                </template>
              </el-table-column>
            </el-table-column>
            <el-table-column align="center" prop="params">
              <template slot="header" slot-scope="scope"
                ><div>Params<br />(MParams)</div>
                <el-slider
                  v-if="activeName == 0"
                  v-model="sentenceParamsValue"
                  range
                  @input="sentenceParamsChange"
                  :max="sentenceParamsMax"
                  :min="sentenceParamsMin"
                >
                </el-slider>
              </template>
            </el-table-column>
            <el-table-column v-if="false" align="center" prop="flops">
              <template slot="header" slot-scope="scope"
                ><div>FLOPs<br />(MFLOPs)</div>
                <el-slider
                  v-if="activeName == 0"
                  v-model="sentenceFlopsValue"
                  range
                  @input="sentenceFlopsChange"
                  :max="sentenceFlopsMax"
                  :min="sentenceFlopsMin"
                >
                </el-slider>
              </template>
            </el-table-column>
            <el-table-column
              :label="remark"
              align="center"
              prop="average"
              sortable
              :sort-method="sortByPaperScore"
            >
            </el-table-column>
          </el-table>
        </div>
        <p
          v-if="false"
          style="
            text-align: center;
            font-size: 20px;
            color: #13227a;
            margin: 5rem;
          "
        >
          <b>Token-Level Tasks</b>
        </p>

        <div style="width: 90%; margin: auto" v-if="false">
          <el-table
            empty-text="No Data"
            stripe
            tooltip-effect="dark"
            :data="tokenModelPerformanceListShow"
            :row-style="getRowClass"
            :header-row-style="getRowClass"
            :header-cell-style="getRowClass"
            :border="true"
          >
            <el-table-column align="center" label="Model" prop="modelName">
            </el-table-column>
            <el-table-column
              v-for="(item, index) in tokenTask"
              :key="item.taskId"
              align="center"
            >
              <template slot="header" slot-scope="scope"
                ><span>{{ item.taskName }}</span>
              </template>
              <el-table-column
                align="center"
                v-for="item1 in datasetList1[index]"
                :key="item1.datasetId"
                :prop="item1.datasetName"
              >
                <template slot="header" slot-scope="scope"
                  ><span>{{ item1.datasetName }}</span>
                </template>
              </el-table-column>
            </el-table-column>
            <el-table-column align="center" prop="params">
              <template slot="header" slot-scope="scope"
                ><div>Params(MParams)</div>
                <el-slider
                  v-model="tokenParamsValue"
                  range
                  @input="tokenParamsChange"
                  :max="tokenParamsMax"
                  :min="tokenParamsMin"
                >
                </el-slider>
              </template>
            </el-table-column>
            <el-table-column align="center" prop="flops">
              <template slot="header" slot-scope="scope"
                ><div>Flops(MFLOPs)</div>
                <el-slider
                  v-model="tokenFlopsValue"
                  range
                  @input="tokenFlopsChange"
                  :max="tokenFlopsMax"
                  :min="tokenFlopsMin"
                >
                </el-slider>
              </template>
            </el-table-column>
            <el-table-column
              label="Average Score"
              align="center"
              prop="average"
              sortable
            >
            </el-table-column>
          </el-table>
        </div>
      </el-main>
      <el-footer height="1.5rem" style="font-size: 0.9rem; text-align: left">
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
import {
  Login,
  Signup,
  GetTokenTask,
  GetSentenceTask,
} from "@/api/landingPage";
import {
  GetDatasetByTaskList,
  GetModelPerformance,
  GetSubmitPerformance,
} from "@/api/leaderboardPage";
import { parse } from "qs";
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
      sentenceParamsValue: [4, 8],
      sentenceParamsMax: -1,
      sentenceParamsMin: 9999999999,
      spmax: -1,
      spmin: 9999999999,
      sentenceFlopsValue: [4, 8],
      sentenceFlopsMax: -1,
      sentenceFlopsMin: 9999999999,
      remark: "Average Score",
      tokenParamsValue: [4, 8],
      tokenParamsMax: -1,
      tokenParamsMin: 9999999999,
      tpmax: -1,
      tpmin: 9999999999,
      tokenFlopsValue: [4, 8],
      tokenFlopsMax: -1,
      tokenFlopsMin: 9999999999,

      tokenTask: [],
      sentenceTask: [],
      datasetList: [],
      datasetList1: [],
      sentenceModelPerformanceList: [],
      sentenceModelPerformanceListShow: [],
      tokenModelPerformanceList: [],
      tokenModelPerformanceListShow: [],
      loading: null,
      activeName: "0",
    };
  },

  methods: {
    sortByPaperScore(obj1, obj2) {
      return obj1.average - obj2.average;
    },

    handleClick(tab, event) {
      this.loading = this.$loading({
        lock: true,
        text: "Loading",
        spinner: "el-icon-loading",
        background: "rgba(0, 0, 0, 0.7)",
      });
      let datasetList = [];
      for (let i = 0; i < this.datasetList.length; i++) {
        datasetList.push(this.datasetList[i].datasetName);
      }
      let data = {
        datasetList: datasetList.toString(),
        kind: "sentence level",
        mode: this.activeName == "0",
      };
      GetModelPerformance(data)
        .then((response) => {
          this.sentenceModelPerformanceList = response.data.performanceList;

          let datasetList = [];
          for (let i = 0; i < this.datasetList.length; i++) {
            datasetList.push(this.datasetList[i].datasetName);
          }
          let data = {
            datasetList: datasetList.toString(),
            kind: "sentence level",
            mode: this.activeName == "0",
          };
          GetSubmitPerformance(data)
            .then((response) => {
              for (let i = 0; i < response.data.performanceList.length; i++) {
                this.sentenceModelPerformanceList.push(
                  response.data.performanceList[i]
                );
              }
              this.sentenceModelPerformanceListShow =
                this.sentenceModelPerformanceList;

              for (
                let j = 0;
                j < this.sentenceModelPerformanceListShow.length;
                j++
              ) {
                if (
                  this.sentenceParamsMax <
                  parseInt(this.sentenceModelPerformanceListShow[j].params)
                )
                  this.sentenceParamsMax = parseInt(
                    this.sentenceModelPerformanceListShow[j].params
                  );
                if (
                  this.sentenceParamsMin >
                  parseInt(this.sentenceModelPerformanceListShow[j].params)
                )
                  this.sentenceParamsMin = parseInt(
                    this.sentenceModelPerformanceListShow[j].params
                  );
              }
              this.sentenceParamsValue[0] = this.sentenceParamsMin;
              this.sentenceParamsValue[1] = this.sentenceParamsMax;
              this.sentenceFlopsValue[0] = this.sentenceFlopsMin;
              this.sentenceFlopsValue[1] = this.sentenceFlopsMax;
              this.spmax = this.sentenceParamsMax;
              this.spmin = this.sentenceParamsMin;

              let params = parseInt(tab.name);
              if (params == 110) {
                this.remark = "Performance";
                this.attribute = "performs";
                this.sentenceModelPerformanceListShow = [];

                for (
                  let index = 0;
                  index < this.sentenceModelPerformanceList.length;
                  index++
                ) {
                  if (this.sentenceModelPerformanceList[index].params <= params)
                    this.sentenceModelPerformanceListShow.push(
                      this.sentenceModelPerformanceList[index]
                    );
                }
              } else if (params > 0) {
                this.remark = "Performance";

                this.sentenceModelPerformanceListShow = [];

                for (
                  let index = 0;
                  index < this.sentenceModelPerformanceList.length;
                  index++
                ) {
                  if (this.sentenceModelPerformanceList[index].params <= params)
                    this.sentenceModelPerformanceListShow.push(
                      this.sentenceModelPerformanceList[index]
                    );
                }
              } else {
                this.remark = "Average Score";

                this.sentenceModelPerformanceListShow = [];

                for (
                  let index = 0;
                  index < this.sentenceModelPerformanceList.length;
                  index++
                ) {
                  this.sentenceModelPerformanceListShow.push(
                    this.sentenceModelPerformanceList[index]
                  );
                }
              }

              //console.log(123);
              //console.log(this.sentenceModelPerformanceListShow);
              this.loading.close();
            })
            .catch((error) => {
              //console.log(error);
            });
        })
        .catch((error) => {
          //console.log(error);
        });
    },
    tokenFlopsChange(value) {
      this.tfmin = value[0];
      this.tfmax = value[1];
      this.tokenModelPerformanceListShow = [];
      for (
        let index = 0;
        index < this.tokenModelPerformanceList.length;
        index++
      ) {
        if (
          this.tokenModelPerformanceList[index].flops >= this.tfmin &&
          this.tokenModelPerformanceList[index].flops <= this.tfmax &&
          this.tokenModelPerformanceList[index].params >= this.tpmin &&
          this.tokenModelPerformanceList[index].params <= this.tpmax
        )
          this.tokenModelPerformanceListShow.push(
            this.tokenModelPerformanceList[index]
          );
      }
    },
    tokenParamsChange(value) {
      this.tpmin = value[0];
      this.tpmax = value[1];
      this.tokenModelPerformanceListShow = [];
      for (
        let index = 0;
        index < this.tokenModelPerformanceList.length;
        index++
      ) {
        if (
          this.tokenModelPerformanceList[index].params >= this.tpmin &&
          this.tokenModelPerformanceList[index].params <= this.tpmax &&
          this.tokenModelPerformanceList[index].flops >= this.tfmin &&
          this.tokenModelPerformanceList[index].flops <= this.tfmax
        )
          this.tokenModelPerformanceListShow.push(
            this.tokenModelPerformanceList[index]
          );
      }
    },
    sentenceFlopsChange(value) {
      this.sfmin = value[0];
      this.sfmax = value[1];
      //console.log(this.sfmin);
      //console.log(this.sfmax);
      //console.log(this.spmin);
      //console.log(this.spmax);
      this.sentenceModelPerformanceListShow = [];
      for (
        let index = 0;
        index < this.sentenceModelPerformanceList.length;
        index++
      ) {
        if (
          this.sentenceModelPerformanceList[index].flops >= this.sfmin &&
          this.sentenceModelPerformanceList[index].flops <= this.sfmax &&
          this.sentenceModelPerformanceList[index].params >= this.spmin &&
          this.sentenceModelPerformanceList[index].params <= this.spmax
        )
          this.sentenceModelPerformanceListShow.push(
            this.sentenceModelPerformanceList[index]
          );
      }
    },
    sentenceParamsChange(value) {
      this.spmin = value[0];
      this.spmax = value[1];
      this.sentenceModelPerformanceListShow = [];
      for (
        let index = 0;
        index < this.sentenceModelPerformanceList.length;
        index++
      ) {
        if (
          this.sentenceModelPerformanceList[index].params >= this.spmin &&
          this.sentenceModelPerformanceList[index].params <= this.spmax
        )
          this.sentenceModelPerformanceListShow.push(
            this.sentenceModelPerformanceList[index]
          );
      }
    },
    getModelPerformance() {
      let datasetList = [];
      for (let i = 0; i < this.datasetList.length; i++) {
        datasetList.push(this.datasetList[i].datasetName);
      }
      let data = {
        datasetList: datasetList.toString(),
        kind: "sentence level",
        mode: this.activeName == "0",
      };
      GetModelPerformance(data)
        .then((response) => {
          this.sentenceModelPerformanceList = response.data.performanceList;

          let datasetList = [];
          for (let i = 0; i < this.datasetList.length; i++) {
            datasetList.push(this.datasetList[i].datasetName);
          }
          let data = {
            datasetList: datasetList.toString(),
            kind: "sentence level",
            mode: this.activeName == "0",
          };
          GetSubmitPerformance(data)
            .then((response) => {
              for (let i = 0; i < response.data.performanceList.length; i++) {
                this.sentenceModelPerformanceList.push(
                  response.data.performanceList[i]
                );
              }
              this.sentenceModelPerformanceListShow =
                this.sentenceModelPerformanceList;

              for (
                let j = 0;
                j < this.sentenceModelPerformanceListShow.length;
                j++
              ) {
                if (
                  this.sentenceParamsMax <
                  parseInt(this.sentenceModelPerformanceListShow[j].params)
                )
                  this.sentenceParamsMax = parseInt(
                    this.sentenceModelPerformanceListShow[j].params
                  );
                if (
                  this.sentenceParamsMin >
                  parseInt(this.sentenceModelPerformanceListShow[j].params)
                )
                  this.sentenceParamsMin = parseInt(
                    this.sentenceModelPerformanceListShow[j].params
                  );
              }
              this.sentenceParamsValue[0] = this.sentenceParamsMin;
              this.sentenceParamsValue[1] = this.sentenceParamsMax;
              this.sentenceFlopsValue[0] = this.sentenceFlopsMin;
              this.sentenceFlopsValue[1] = this.sentenceFlopsMax;
              this.spmax = this.sentenceParamsMax;
              this.spmin = this.sentenceParamsMin;

              //console.log(123);
              //console.log(this.sentenceModelPerformanceListShow);
              this.loading.close();
            })
            .catch((error) => {
              //console.log(error);
            });
        })
        .catch((error) => {
          //console.log(error);
        });
    },
    getDatasetByTaskList: function () {
      //console.log("getDatasetByTaskList");
      let array = [];
      for (let i = 0; i < this.sentenceTask.length; i++) {
        array.push(this.sentenceTask[i].taskId);
      }
      let data = {
        taskList: array.toString(),
      };
      GetDatasetByTaskList(data)
        .then((response) => {
          for (let i = 0; i < this.sentenceTask.length; i++) {
            this.datasetList.push(response.data.datasetList[i]);
          }
        })
        .catch((error) => {
          //console.log(error);
        });

      array = [];
      for (let i = 0; i < this.tokenTask.length; i++) {
        array.push(this.tokenTask[i].taskId);
      }
      data = {
        taskList: array.toString(),
      };
      GetDatasetByTaskList(data)
        .then((response) => {
          for (let i = 0; i < this.tokenTask.length; i++) {
            this.datasetList1.push(response.data.datasetList[i]);
          }
        })
        .catch((error) => {
          //console.log(error);
        });
    },
    getTask: function () {
      GetTokenTask()
        .then((response) => {
          //console.log("getTask");
          this.tokenTask = response.data.tasklist;
        })
        .catch((error) => {
          //console.log(error);
        });

      GetSentenceTask()
        .then((response) => {
          //console.log("getTask");
          this.sentenceTask = response.data.tasklist;
          this.getDatasetByTaskList();
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
    getRowClass({ row, column, rowIndex, columnIndex }) {
      return "background:#13227A;color:#fff";
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
          this.state = "login";
          this.email = "";
          this.pwd = "";
          this.dialogVisible = false;
        })
        .catch((error) => {
          //console.log(error);
          this.$message.error("Incorrect username or password.");
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
  },
  created() {
    this.loading = this.$loading({
      lock: true,
      text: "Loading",
      spinner: "el-icon-loading",
      background: "rgba(0, 0, 0, 0.7)",
    });
    if (window.localStorage.getItem("token") != null) this.state = "login";
    else this.state = "not login";
    this.getTask();
    this.getModelPerformance();
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

.el-footer {
  background-color: #13227a;
  color: #ffffff;
  width: 100%;
}
</style>
