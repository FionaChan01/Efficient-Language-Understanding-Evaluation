
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
                  index="#"
                  @click="showLoginDialog"
                  v-if="state == 'not login'"
                  >Login</el-menu-item
                >
                <el-menu-item
                  style="font-size: 1.2rem"
                  index="#"
                  v-if="state == 'login'"
                  @click="handleCommand"
                  >Logout</el-menu-item
                >
              </el-menu>
            </div></el-col
          >
        </el-row>
      </el-header>
      <el-main style="text-align: center"
        ><h3 style="font-size: 50px; text-align: center">About</h3>
        <p
          style="
            margin: auto;
            text-align: justify;
            font-size: 25px;
            width: 900px;
          "
        >
          <b>What is ELUE?</b>
        </p>

        <p
          style="
            margin: auto;
            text-align: justify;
            font-size: 20px;
            width: 900px;
          "
        >
          ELUE is a standard benchmark and platform for efficient NLP models. It
          is developed for NLP researchers who are interested in efficient
          methods including model compression, dynamic early exiting, etc. ELUE
          is developed by a team of NLP researchers at Fudan University and
          Huawei Poisson Lab.
        </p>
        <br />

        <p
          style="
            margin: auto;
            text-align: justify;
            font-size: 25px;
            width: 900px;
          "
        >
          <b>What does the logo mean?</b>
        </p>

        <p
          style="
            margin: auto;
            text-align: justify;
            font-size: 20px;
            width: 900px;
          "
        >
          The cube in the logo means multi-dimension. The three curves in the
          cube represent the three dimensions evaluated in ELUE: performance,
          FLOPs, and number of parameters.
        </p>
        <br />
        <p
          style="
            margin: auto;
            text-align: justify;
            font-size: 25px;
            width: 900px;
          "
        >
          <b>What’s the difference between ELUE and GLUE/CLUE?</b>
        </p>

        <p
          style="
            margin: auto;
            text-align: justify;
            font-size: 20px;
            width: 900px;
          "
        >
          Good question! <b>First</b>, GLUE and CLUE are benchmarks to evaluate
          model accuracy, while for efficient models, you have to measure your
          model efficiency by yourself. Unfortunately, different researchers
          usually adopt different metrics (e.g., number of parameters, FLOPs,
          actual inference time, etc.), making their methods hard to compare. As
          a standardized evaluation, ELUE is needed. <b>Second</b>, for dynamic
          methods such as early exiting, you usually need to plot a
          performance-efficiency curve for each dataset, which is inconvenient
          using GLUE/CLUE due to their submission limitation. And besides, ELUE
          can evaluate and record your performance-efficiency curves, such that
          you can make a comprehensive comparison with other early exiting
          methods.
        </p>

        <br />

        <p
          style="
            margin: auto;
            text-align: justify;
            font-size: 25px;
            width: 900px;
          "
        >
          <b>What can I do with ELUE?</b>
        </p>

        <p
          style="
            margin: auto;
            text-align: justify;
            font-size: 20px;
            width: 900px;
          "
        >
          <b>As a benchmark</b>, ELUE can measure the FLOPs and number of
          parameters for your submitted model. By standard evaluation, you can
          get your model fairly and comprehensively compared with other models.
          <b>As an open-source platform</b>, all of the baseline results in ELUE
          are publicly accessible to facilitate your research. We’ve reproduced
          (and will constantly reproduce) various efficient models (e.g.,
          DistilBERT, TinyBERT, DeeBERT, PABEE, etc.) and shared all the results
          in ELUE.
        </p>

        <br />

        <p
          style="
            margin: auto;
            text-align: justify;
            font-size: 25px;
            width: 900px;
          "
        >
          <b>How can I make a submission to ELUE?</b>
        </p>

        <p
          style="
            margin: auto;
            text-align: justify;
            font-size: 20px;
            width: 900px;
          "
        >
          You are allowed to make two kinds of submissions: submit from a
          published paper (with a code repo), or submit test files predicted by
          your model. For the first way, we encourage the authors who published
          papers about efficient NLP methods to share their experimental results
          on ELUE. Besides, we also reproduced many papers and shared our
          results on ELUE. For the second way, you should submit your predicted
          test files (under different FLOPs) and a Python file to define your
          model (optional). See
          <a
            href="http://101.34.210.253:8099/SubmissionGuide.pdf"
            style="font-size: 20px"
            >submission guide</a
          >
          for more details.
        </p>

        <br />

        <p
          style="
            margin: auto;
            text-align: justify;
            font-size: 25px;
            width: 900px;
          "
        >
          <b>How is score calculated in ELUE Leaderboard?</b>
        </p>

        <p
          style="
            margin: auto;
            text-align: justify;
            font-size: 20px;
            width: 900px;
          "
        >
          Because dynamic models can have multiple coordinates (performance,
          FLOPs) that can form a performance-efficiency curve on each dataset,
          we need to score the performance-efficiency curve for each model. For
          a submission with coordinates `(Perf_i,Flops_i )_(i=1)^n`, we devised
          a score to measure the extent to which the submission overrides the
          curve of ElasticBERT:
        </p>
        <br />
        <p
          class="formula"
          style="
            margin: auto;
            text-align: justify;
            font-size: 20px;
            width: 900px;
          "
        >
          <center>
            ELUE_score`=1/n ∑_(i=1)^n (Perf_i-Perf^{EB} (Flops_i))`
          </center>
        </p>
        <br />
        <p
          class="formula"
          style="
            margin: auto;
            text-align: justify;
            font-size: 20px;
            width: 900px;
          "
        >
          where `Perf^{EB} (Flops)` is the performance-FLOPs curve that is
          obtained by interpolating the coordinates of `Ela sticBERT_{BASE}`.
          The computation of the ELUE score can be illustrated by the figure
          below:
        </p>
        <br />

        <el-image
          style="width: 55rem; height: 27.5rem"
          :src="measure"
        ></el-image>
        <br />

        <p
          style="
            margin: auto;
            text-align: justify;
            font-size: 25px;
            width: 900px;
          "
        >
          <b>What if I run into some problems with ELUE?</b>
        </p>

        <p
          style="
            margin: auto;
            text-align: justify;
            font-size: 20px;
            width: 900px;
          "
        >
          You are suggested to read our <a href="https://txsun1997.github.io/papers/elue_paper.pdf">paper</a> for more
          details. If you have any problem, please reach out to
          <a href="mailto:txsun19@fudan.edu.cn">txsun19@fudan.edu.cn</a>.
        </p>

        <div style="margin: 5rem"></div>
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
          style="margin: 10px; width: 100%; color: #ffffff; background: #13227a"
          >Login</el-button
        >
        <el-button
          v-if="loginOrSignup == 'signup'"
          type="primary"
          @click="submitSignup"
          style="margin: 10px; width: 100%; color: #ffffff; background: #13227a"
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

const sha256 = require("js-sha256").sha256;
export default {
  components: {
    katex: {
      render(createElement) {
        return createElement("script", {
          attrs: {
            type: "text/javascript",
            src: "https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.5/MathJax.js?config=TeX-MML-AM_CHTML",
          },
        });
      },
    },
  },
  data() {
    return {
      logo: require("../../assets/logo.png"),
      measure: require("../../assets/measure.png"),
      dialogVisible: false,
      email: "",
      pwd: "",
      loginOrSignup: "login",
      username: "",
      state: "not login",
    };
  },

  methods: {
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
          console.log("login");
          window.localStorage.setItem("username", response.data.username);

          window.localStorage.setItem("token", response.data.token);
          this.state = "login";
          this.email = "";
          this.pwd = "";
          this.dialogVisible = false;
        })
        .catch((error) => {
          console.log(error);
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
          console.log("signup");
          this.login();
          this.email = "";
          this.pwd = "";
          this.username = "";
          this.dialogVisible = false;
        })
        .catch((error) => {
          console.log(error);
          this.$message.error("Email account already exists.");
        });
    },
    handleCommand(command) {
      this.state = "not login";
      window.localStorage.clear();
    },
  },
  
  created() {
    if (window.localStorage.getItem("token") != null) {
      this.state = "login";
      this.token = window.localStorage.getItem("token");
    } else this.state = "not login";

    // location.reload()
    
  },
  mounted() {
    const s = document.createElement("script");
    s.type = "text/javascript";
    s.src =
      "https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.5/MathJax.js?config=TeX-MML-AM_CHTML";
    document.body.appendChild(s);
  },
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
