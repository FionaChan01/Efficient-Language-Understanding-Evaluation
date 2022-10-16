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
        <el-image
          style="width: 26rem; height: 13rem; margin-top: 3rem"
          :src="logo"
        ></el-image>
        <br />
        <p
          style="
            margin: auto;
            text-align: justify;
            font-size: 20px;
            width: 700px;
            margin-top: 30px;
          "
        >
          <b>ELUE</b> (<b>E</b>fficient <b>L</b>anguage <b>U</b>nderstanding
          <b>E</b>valuation) is a standard benchmark for efficient NLP models.
        </p>
        <p
          style="
            margin: auto;
            text-align: justify;
            font-size: 20px;
            width: 700px;
          "
        >
          ● ELUE supports online evaluation for model performance, FLOPs, and
          number of parameters.
        </p>
        <p
          style="
            margin: auto;
            text-align: justify;
            font-size: 20px;
            width: 700px;
          "
        >
          ● ELUE is an open-source platform that can facilitate future research.
          Many compressed models and early exiting models have been reproduced
          and evaluated on ELUE. All of the results are publicly accessible.
        </p>
        <p
          style="
            margin: auto;
            text-align: justify;
            font-size: 20px;
            width: 700px;
          "
        >
          ● ELUE provides an online leaderboard that uses a specific metric to
          measure how much a submission oversteps the current Pareto front. ELUE
          leaderboard also maintains several separate tracks for models with
          different sizes.
        </p>

        <p
          style="
            margin: auto;
            text-align: justify;
            font-size: 20px;
            width: 700px;
          "
        >
          ● ELUE covers six NLP datasets spanning sentiment analysis, natural
          language inference, similarity and paraphrase tasks.
        </p>

        <el-button
          style="margin-top: 5rem; color: #ffffff; background: #2b5283"
          :round="true"
          @click="getPaper"
          size="medium"
          ><b>Paper<i class="el-icon-notebook-2 el-icon--right"></i></b
        ></el-button>

        <el-button
          style="margin-top: 5rem; color: #ffffff; background: #2b5283"
          :round="true"
          size="medium"
          @click="getAllDatasets"
          ><b>Datasets<i class="el-icon-download el-icon--right"></i></b
        ></el-button>

        <p
          style="
            text-align: center;
            font-size: 20px;
            color: #13227a;
            margin: 5rem;
          "
        ></p>

        <el-row type="flex" justify="space-around">
          <el-col :span="2"><div class="grid-content"></div></el-col>
          <el-col :span="5" v-for="item in sentenceTask" :key="item.taskId">
            <div @click="toTaskPage(item.taskId)" v-loading="loadSentence">
              <el-card
                :body-style="{ padding: '0px' }"
                class="card"
                v-loading="loadToken"
                style="border-radius: 20px"
              >
                <div
                  style="padding: 14px; height: 180px; font-size: 20px"
                  @mouseenter="changeActive($event)"
                  @mouseleave="removeActive($event)"
                >
                  <span
                    ><b>{{ item.taskName }}</b></span
                  >
                  <br />
                  <el-image
                    @click="toTaskPage(item.taskId)"
                    style="width: 50px; height: 50px; margin: 30px"
                    :src="item.taskUrl"
                    fit="contain"
                  />
                </div>
              </el-card>
            </div>
          </el-col>
          <el-col :span="2"><div class="grid-content"></div></el-col>
        </el-row>

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

        <el-row type="flex" justify="space-around" v-if="false">
          <el-col :span="2"><div class="grid-content"></div></el-col>
          <el-col :span="5" v-for="item in tokenTask" :key="item.taskId">
            <div @click="toTaskPage(item.taskId)" v-loading="loadToken">
              <el-card
                :body-style="{ padding: '0px' }"
                @click="toTaskPage(item.taskId)"
                class="card"
                style="border-radius: 20px"
              >
                <div
                  style="padding: 14px; height: 180px; font-size: 20px"
                  @mouseenter="changeActive($event)"
                  @mouseleave="removeActive($event)"
                >
                  <span
                    ><b>{{ item.taskName }}</b></span
                  >
                  <br />
                  <el-image
                    @click="toTaskPage(item.taskId)"
                    style="width: 50px; height: 50px; margin: 30px"
                    :src="item.taskUrl"
                    fit="contain"
                  />
                </div>
              </el-card>
            </div>
          </el-col>
          <el-col :span="2"><div class="grid-content"></div></el-col>
        </el-row>
        <el-footer
          height="1.5rem"
          style="font-size: 0.9rem; margin-top: 20rem; text-align: left"
        >
          Copyright©2021 Fudan University - All Rights Reserved.
          <el-link type="primary" href="https://txsun1997.github.io/"
            >Contact</el-link
          >
        </el-footer>
      </el-main>
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
const sha256 = require("js-sha256").sha256;
export default {
  data() {
    return {
      loadSentence: true,
      loadToken: true,
      logo: require("../../assets/logo.png"),
      dialogVisible: false,
      email: "",
      pwd: "",
      loginOrSignup: "login",
      username: "",
      state: "not login",
      tokenTask: [],
      sentenceTask: [],
      loading: "",
    };
  },

  methods: {
    getPaper(){
      window.location.href = "https://txsun1997.github.io/papers/elue_paper.pdf"
    },
    getAllDatasets() {
      window.location.href =
        "http://101.34.210.253:8099/elue_data.zip";
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
    toTaskPage: function (taskId) {
      //console.log("toTaskPage");
      this.$router.push({ path: "/task", query: { taskId: taskId } });
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
    getTask: function () {
      GetTokenTask()
        .then((response) => {
          //console.log("getTask");
          this.tokenTask = response.data.tasklist;
          this.loadToken = false;
          //console.log(this.tokenTask);
        })
        .catch((error) => {
          //console.log(error);
        });

      GetSentenceTask()
        .then((response) => {
          //console.log("getTask");
          this.sentenceTask = response.data.tasklist;
          this.loadSentence = false;
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
    changeActive($event) {
      $event.currentTarget.className = "boxShadow";
    },
    removeActive($event) {
      $event.currentTarget.className = "";
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

.task {
  height: 100%;
}

.row-bg {
  padding: 10px 0;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.tasks {
  cursor: pointer;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}

.card {
  cursor: pointer;
  background-color: #f6f8fa;
}

.boxShadow {
  background-color: #99a9bf;
}

.el-footer {
  background-color: #13227a;
  color: #ffffff;
  width: 100%;
}
</style>
