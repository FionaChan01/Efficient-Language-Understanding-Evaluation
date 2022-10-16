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
        <h3 style="font-size: 30px; text-align: center">
          {{ this.task.taskName }}
        </h3>
        <p style="font-size: 15px; text-align: center">
          {{ this.task.taskDescription }}
        </p>
        <div style="text-align: center; margin-top: 30px">
          <el-dropdown @command="chooseDataset" style="margin: 30px">
            <el-button style="color: #ffffff; background: #2b5283">
              Choose Dataset | {{ currentDataset.datasetName
              }}<i class="el-icon-arrow-down el-icon--right"></i>
            </el-button>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item
                v-for="item in datasets"
                :key="item.datasetId"
                :command="item"
                >{{ item.datasetName }}</el-dropdown-item
              >
            </el-dropdown-menu>
          </el-dropdown>
          <el-button
            style="margin: 30px; color: #ffffff; background: #2b5283"
            @click="getFile"
          >
            Download Dataset<i class="el-icon-download el-icon--right"></i>
          </el-button>
          <el-button
            style="margin: 30px; color: #ffffff; background: #2b5283"
            @click="showSubmitPaper"
          >
            Submit Paper<i class="el-icon-upload2 el-icon--right"></i>
          </el-button>
          <el-button
            style="margin: 30px; color: #ffffff; background: #2b5283"
            @click="showSubmitFile"
          >
            Submit Testfile<i class="el-icon-upload2 el-icon--right"></i>
          </el-button>
          <el-button
            style="margin: 30px; color: #ffffff; background: #2b5283"
            @click="getGuide"
            >Submission Guide<i class="el-icon-guide el-icon--right"></i
          ></el-button>
        </div>
        <h3 style="font-size: 30px; text-align: center">
          Model Performance VS.<el-dropdown
            @command="chooseXName"
            style="margin-left: 20px"
          >
            <el-button style="color: #ffffff; background: #2b5283">
              {{ xName }}<i class="el-icon-arrow-down el-icon--right"></i>
            </el-button>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item
                v-for="item in xNames"
                :key="item"
                :command="item"
                >{{ item }}</el-dropdown-item
              >
            </el-dropdown-menu>
          </el-dropdown>
        </h3>

        <div id="g1" style="height: 600px; width: 100%; margin: auto"></div>

        <el-row type="flex" justify="space-around">
          <el-col :span="11"
            ><div class="grid-content">
              <h3 style="font-size: 30px; text-align: center">
                Model Leaderboard (Papers)
              </h3>
              <div
                style="height: 400px; width: 100%; margin: auto"
                class="table-wrapper"
              >
                <el-table
                  max-height="300"
                  ref="paperTable"
                  empty-text="No Data"
                  v-loading="loadingPaper"
                  element-loading-text="Loading"
                  element-loading-spinner="el-icon-loading"
                  element-loading-background="rgba(0, 0, 0, 0.8)"
                  :data="paperList"
                  stripe
                  tooltip-effect="dark"
                  style="color: #000000"
                  @selection-change="handlePaperSelectionChange"
                  :row-style="getRowClass"
                  :header-row-style="getRowClass"
                  :header-cell-style="getRowClass"
                  :border="true"
                  :default-sort="{
                    prop: 'paperScore',
                    order: 'descending',
                  }"
                >
                  <el-table-column
                    align="center"
                    type="selection"
                    :selectable="selectablepaper"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="paperModel"
                    label="Model"
                    show-overflow-tooltip
                    align="center"
                    width="200px"
                  >
                  </el-table-column>
                  <el-table-column
                    label="Paper"
                    v-slot="scope"
                    show-overflow-tooltip
                    align="center"
                  >
                    <el-link :href="scope.row.paperWebsite">{{
                      scope.row.paperName
                    }}</el-link></el-table-column
                  >
                  <el-table-column
                    prop="paperDescription"
                    label="Param"
                    show-overflow-tooltip
                    align="center"
                    width="70px"
                  >
                  </el-table-column>

                  <el-table-column
                    align="center"
                    prop="paperCode"
                    label="Code"
                    v-slot="scope"
                    width="60px"
                  >
                    <div
                      class="grid-content logo"
                      @click="toPage(scope.row.paperCode)"
                    >
                      <el-image
                        style="width: 25px; height: 25px"
                        :src="githublogo"
                      ></el-image>
                    </div>
                  </el-table-column>

                  <el-table-column
                    prop="paperScore"
                    label="Score"
                    show-overflow-tooltip
                    sortable
                    :sort-method="sortByPaperScore"
                    width="110px"
                  >
                  </el-table-column>
                </el-table>
              </div></div
          ></el-col>
          <el-col :span="11"
            ><div class="grid-content">
              <h3 style="font-size: 30px; text-align: center">
                Model Leaderboard (Submissions)
              </h3>
              <div
                style="height: 400px; width: 100%; margin: auto"
                class="table-wrapper"
              >
                <el-table
                  max-height="300"
                  empty-text="No Data"
                  v-loading="loadingSubmission"
                  element-loading-text="Loading"
                  element-loading-spinner="el-icon-loading"
                  element-loading-background="rgba(0, 0, 0, 0.8)"
                  ref="submissionTable"
                  :data="submissionList"
                  tooltip-effect="dark"
                  style="color: #000000"
                  @selection-change="handleSubmissionSelectionChange"
                  :border="true"
                  :row-style="getRowClass"
                  :header-row-style="getRowClass"
                  :header-cell-style="getRowClass"
                  :default-sort="{
                    prop: 'submissionScore',
                    order: 'descending',
                  }"
                >
                  <el-table-column
                    align="center"
                    type="selection"
                    :selectable="selectablesubmission"
                  >
                  </el-table-column>
                  <el-table-column
                    align="center"
                    prop="submissionName"
                    label="Submission"
                    show-overflow-tooltip
                  >
                  </el-table-column>
                  <el-table-column
                    align="center"
                    prop="submissionDescription"
                    label="Description"
                    show-overflow-tooltip
                  >
                  </el-table-column>
                  <el-table-column
                    align="center"
                    prop="submissionAffiliation"
                    label="Affiliation"
                    show-overflow-tooltip
                  >
                  </el-table-column>

                  <el-table-column
                    prop="submissionParams"
                    label="Param"
                    show-overflow-tooltip
                    align="center"
                  >
                  </el-table-column>

                  <el-table-column
                    prop="submissionScore"
                    label="Score"
                    show-overflow-tooltip
                    sortable
                  >
                  </el-table-column>
                </el-table>
              </div></div
          ></el-col>
        </el-row>
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
      center
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
    <el-dialog
      :visible.sync="submitPaperVisble"
      width="50%"
      :show-close="false"
      center
    >
      <span class="dialog-footer">
        <p style="text-align: center; font-size: 20px"><b>Paper Info</b></p>
        <el-input
          v-model="papername"
          placeholder="Model"
          style="margin: 10px"
          clearable
        ></el-input>
        <el-input
          v-model="papertitle"
          placeholder="Paper Title"
          style="margin: 10px"
          clearable
        ></el-input>
        <el-input
          v-model="paperwebsite"
          placeholder="Paper URL"
          style="margin: 10px"
          clearable
          ><template slot="prepend">http://</template></el-input
        >
        <el-input
          v-model="papercode"
          placeholder="Code URL"
          style="margin: 10px"
          clearable
          ><template slot="prepend">http://</template></el-input
        >
        <p style="text-align: center; font-size: 20px"><b>Performance</b></p>
        <el-button style="color: #ffffff; background: #2b5283" @click="addModel"
          >Add</el-button
        >
        <el-button
          style="color: #ffffff; background: #2b5283"
          @click="deleteModel"
          v-if="newModels.length > 1"
          >Delete</el-button
        >
        <el-button
          style="color: #ffffff; background: #2b5283"
          @click="submitPaper"
          v-loading.fullscreen.lock="fullscreenLoading"
          >Submit</el-button
        >
        <div v-for="item in newModels" :key="item.id">
          <el-divider></el-divider>
          <el-input
            v-model="item.remark"
            placeholder="Performance"
            style="margin: 10px"
            clearable
            ><template slot="append">{{
              currentDataset.datasetEvalution
            }}</template></el-input
          >
          <el-input
            v-model="item.flops"
            placeholder="FLOPs"
            style="margin: 10px"
            clearable
            ><template slot="append">MFLOPs</template></el-input
          >
          <el-input
            v-model="item.params"
            placeholder="Params"
            style="margin: 10px"
            clearable
            ><template slot="append">MParams</template></el-input
          >
        </div>
      </span>
    </el-dialog>
    <el-dialog :visible.sync="submitfileVisible" width="50%" center>
      <div style="text-align: center; margin: 1rem">
        <el-switch
          v-model="submitType"
          active-text="Type2"
          inactive-text="Type1"
          active-color="#336699"
          inactive-color="#336699"
        >
        </el-switch>
      </div>
      <div style="text-align: center" v-show="submitType == false">
        <center>
          <el-switch
            v-model="type1type"
            active-text="Dynamic"
            inactive-text="Static"
            active-color="#336699"
            inactive-color="#336699"
            @change="type1typeChange"
          >
          </el-switch>
        </center>
        <el-upload
          class="upload-demo"
          drag
          action="#"
          multiple
          :auto-upload="false"
          :on-change="handleChange"
          :on-remove="handleRemove"
          :file-list="fileList"
          :limit="fileLimit"
          style="margin-top: 10px"
        >
          <i class="el-icon-upload"></i>
          <div class="el-upload__text">
            Drag File Here, Or <em>Click To Upload</em>
          </div>
        </el-upload>

        <el-input
          v-model="submitionname"
          placeholder="Submission"
          style="margin-top: 10px"
          clearable
        ></el-input>
        <el-input
          v-model="description"
          placeholder="Model Description"
          style="margin-top: 10px"
          clearable
        ></el-input>
        <el-input
          v-model="institute"
          placeholder="Affiliation"
          style="margin-top: 10px"
          clearable
        ></el-input>

        <div v-for="item in form" :key="item.id">
          <el-divider></el-divider>
          FLOPs And Params For {{ item.file }}
          <el-input
            v-model="item.flops"
            placeholder="FLOPs"
            style="margin-top: 10px"
            clearable
          >
            <template slot="append">MFLOPs</template></el-input
          >

          <el-input
            v-model="item.params"
            placeholder="Params"
            style="margin-top: 10px"
            clearable
          >
            <template slot="append">MParams</template></el-input
          >
        </div>
        <el-tooltip
          class="item"
          effect="dark"
          content="Your submission will be recorded in the leaderboard."
          placement="top-start"
        >
          <el-button
            style="margin-top: 30px; color: #ffffff; background: #2b5283"
            @click="submitSubmission('leaderboard')"
            v-loading.fullscreen.lock="fullscreenLoading"
            size="small"
            >Start Testing</el-button
          >
        </el-tooltip>

        <el-tooltip
          class="item"
          effect="dark"
          content="Your submission will only be tested for format and return results."
          placement="top-start"
        >
          <el-button
            style="margin-top: 30px; color: #ffffff; background: #2b5283"
            @click="submitSubmission('test')"
            v-loading.fullscreen.lock="fullscreenLoading"
            size="small"
            >Only Test</el-button
          >
        </el-tooltip>
      </div>

      <div v-show="submitType == true">
        <center>
          <el-switch
            v-model="type2type"
            active-text="Dynamic"
            inactive-text="Static"
            active-color="#336699"
            inactive-color="#336699"
            @change="type2typeChange"
          >
          </el-switch>
        </center>
        <el-button
          size="small"
          style="color: #ffffff; background: #2b5283"
          @click="type2add"
          v-if="type2type"
          >Add</el-button
        >
        <el-button
          size="small"
          style="color: #ffffff; background: #2b5283"
          @click="type2delete"
          v-if="type2List.length > 1"
          >Delete</el-button
        >
        <el-input
          v-model="submitionname"
          placeholder="Submission"
          style="margin-top: 10px"
          clearable
        ></el-input>
        <el-input
          v-model="description"
          placeholder="Model Description"
          style="margin-top: 10px"
          clearable
        ></el-input>
        <el-input
          v-model="institute"
          placeholder="Affiliation"
          style="margin-top: 10px"
          clearable
        ></el-input>

        <el-divider></el-divider>
        <div style="text-align: center; margin-top: 1rem">
          <el-upload
            class="upload-demo"
            ref="upload"
            action="#"
            :auto-upload="false"
            :limit="1"
            :on-change="pychange"
          >
            <el-button
              slot="trigger"
              size="small"
              type="primary"
              style="background: #2b5283"
              v-if="pyfile.length == 0"
              >Upload Model File<i class="el-icon-upload el-icon--right"></i
            ></el-button>
            <el-button
              v-if="pyfile.length != 0"
              type="success"
              icon="el-icon-check"
              circle
            ></el-button>

            <div v-if="pyfile.length != 0" slot="tip" class="el-upload__tip">
              A File Is Selected
            </div>
            <div v-if="pyfile.length == 0" slot="tip" class="el-upload__tip">
              Only py Files Can Be Uploaded
            </div>
          </el-upload>
        </div>

        <el-divider></el-divider>
        <div v-for="(item, index) in type2List" :key="index">
          <div style="text-align: center">
            <el-upload
              class="upload-demo"
              ref="upload"
              :limit="1"
              action="#"
              :auto-upload="false"
              :on-change="
                (file, fileList) => {
                  return tsvChange(file, fileList, item);
                }
              "
            >
              <el-button
                v-if="item.tsvfile.length != 0"
                type="success"
                icon="el-icon-check"
                circle
              ></el-button>
              <el-button
                slot="trigger"
                size="small"
                type="primary"
                style="background: #2b5283"
                v-if="item.tsvfile.length == 0"
                >Upload Test File<i class="el-icon-upload el-icon--right"></i
              ></el-button>
              <div
                v-if="item.tsvfile.length == 0"
                slot="tip"
                class="el-upload__tip"
              >
                Only tsv Files Can Be Uploaded
              </div>
              <div
                v-if="item.tsvfile.length != 0"
                slot="tip"
                class="el-upload__tip"
              >
                A File Is Selected
              </div>
            </el-upload>
          </div>

          <el-divider></el-divider>
        </div>
        <div style="text-align: center">
          <el-tooltip
            class="item"
            effect="dark"
            content="Your submission will be recorded in the leaderboard."
            
            placement="top-start"
          >
            <el-button
              style="margin-top: 30px; color: #ffffff; background: #2b5283"
              @click="submitType2"
              size="small"
              >Start Testing</el-button
            >
          </el-tooltip>
          <!-- <el-tooltip
            class="item"
            effect="dark"
            content="Your submission will only be tested for format and return results."
            placement="top-start"
          >
            <el-button
              style="margin-top: 30px; color: #ffffff; background: #2b5283"
              @click="submitType2('test')"
              size="small"
              >Only Test</el-button
            >
          </el-tooltip> -->
        </div>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { Login, Signup } from "@/api/landingPage";
import {
  GetTaskById,
  GetDatasetByTask,
  GetSubmissionByDataset,
  GetPaperByDataset,
  GetModelByPaperList,
  GetSubmitBySubmissionList,
  SubmitPaper,
  SubmitSubmission,
} from "@/api/taskPage";
import * as echarts from "echarts";
import axios from "axios";
const sha256 = require("js-sha256").sha256;
export default {
  data() {
    return {
      fileLimit: 1,
      type2type: false,
      type1type: false,
      pyfile: [],
      type2List: [{ tsvfile: [] }],
      loading: "",
      xmax: 0,
      xmin: 0,
      max: 0,
      min: 0,
      description: "",
      institute: "",
      submitionname: "",
      submitType: false,
      loadingPaper: true,
      loadingSubmission: true,
      form: [],
      submitfileVisible: false,
      xNames: ["FLOPs", "params"],
      papername: "",
      paperwebsite: "",
      papercode: "",
      papertitle: "",
      logo: require("../../assets/logo.png"),
      githublogo: require("../../assets/github.png"),
      dialogVisible: false,
      submitPaperVisble: false,
      email: "",
      pwd: "",
      loginOrSignup: "login",
      username: "",
      state: "not login",
      task: null,
      datasets: [],
      currentDataset: { datasetName: "" },
      xName: "FLOPs",
      legendData: [],
      myChart: null,
      seriesData: [],
      multiplePaperSelection: [],
      multipleSubmissionSelection: [],
      models: [],
      fullscreenLoading: false,
      submits: [],
      newModels: [
        {
          remark: "",
          flops: "",
          params: "",
        },
      ],
      paperList: [
        {
          paperName: "model1",
          paperWebsite: "www.baidu.com",
          paperCode: "www.baidu.com",
        },
      ],
      submissionList: [
        {
          submissionName: "submission1",
          submissionDescription: "test",
          submissionAffiliation: "test",
        },
      ],
      fileList: [],
      token: "",
      limitNum: 11,
    };
  },

  methods: {
    limitsubmissionFn(list) {
      this.$refs.submissionTable.clearSelection();
      for (
        let i = 0;
        i < this.limitNum - this.seriesData.length && i < list.length;
        i++
      ) {
        this.$refs.submissionTable.toggleRowSelection(list[i]);
      }
    },
    limitpaperFn(list) {
      this.$refs.paperTable.clearSelection();
      for (
        let i = 0;
        i < this.limitNum - this.seriesData.length && i < list.length;
        i++
      ) {
        this.$refs.paperTable.toggleRowSelection(list[i]);
      }
    },
    selectablesubmission(row) {
      let index = this.multipleSubmissionSelection.findIndex(
        (v) => v.submissionId === row.submissionId
      );
      if (this.seriesData.length >= this.limitNum - this.seriesData.length) {
        if (index !== -1) {
          return true;
        } else {
          return false;
        }
      } else {
        return true;
      }
    },
    selectablepaper(row) {
      let index = this.multiplePaperSelection.findIndex(
        (v) => v.paperId === row.paperId
      );
      if (this.seriesData.length >= this.limitNum - this.seriesData.length) {
        if (index !== -1) {
          return true;
        } else {
          return false;
        }
      } else {
        return true;
      }
    },
    sortByPaperScore(obj1, obj2) {
      if (obj1.paperModel == "ElasticBERT-BASE") return 1;
      if (obj2.paperModel == "ElasticBERT-BASE") return -1;
      return obj1.paperScore - obj2.paperScore;
    },
    type2typeChange(value) {
      if (!value) this.type2List = [{ tsvfile: [] }];
    },
    type1typeChange(value) {
      if (!value) {
        this.fileLimit = 1;
        while (this.fileList.length > 1) {
          this.fileList.pop();
          this.form.pop();
        }
      } else this.fileLimit = 999;
    },
    getGuide() {
      window.location.href = "http://101.34.210.253:8099/SubmissionGuide.pdf";
    },
    submitType2() {
      if (this.state == "not login") {
        this.$message.error("Please Login First");
        return;
      }
      if (this.description == "") {
        this.$message.error("Model Description Cannot be null");
        return;
      }
      if (this.institute == "") {
        this.$message.error("Affiliation Cannot be null");
        return;
      }
      if (this.submitionname == "") {
        this.$message.error("Submission Name Cannot be null");
        return;
      }
      let f = new FormData();
      if (this.pyfile.length == 0) {
        this.$message.error("Model File Cannot be null");
        return;
      }

      for (let i = 0; i < this.paperList.length; i++) {
        if (this.paperList[i].paperModel == this.submitionname) {
          this.$message.error("Name Already Exist");
          return;
        }
      }

      for (let i = 0; i < this.submissionList.length; i++) {
        if (this.submissionList[i].submissionName == this.submitionname) {
          this.$message.error("Name Already Exist");
          return;
        }
      }

      for (let i = 0; i < this.type2List.length; i++) {
        if (this.type2List[i].tsvfile.length == 0) {
          this.$message.error("Submission File Cannot be null");
          return;
        }
      }
      f.append("pyfile", this.pyfile[0].raw);
      this.type2List.forEach((item) => {
        f.append("tsvfile", item.tsvfile[0].raw);
      });

      f.append("modelDescription", this.description);
      f.append("institute", this.institute);
      f.append("datasetId", this.currentDataset.datasetId);
      f.append("token", this.token);
      f.append("submissionName", this.submitionname);

      this.$message({
        message: "Your model will be evaluated in 12 hours.",
        type: "success",
      });

      this.submitfileVisible = false;
      this.form = [];
      this.description = "";
      this.institute = "";
      this.submitionname = "";
      axios({
        method: "post",
        url: "http://101.34.210.253:8081/submit/submitType2",
        headers: {
          "Content-Type": "multipart/form-data",
        },
        data: f,
      })
        .then((response) => {
          this.getSubmissionByDataset();

          if (response.data.code == "500")
            this.$message.error("Submit Test File Failed");
        })
        .catch((error) => {
          this.$message.error("Submit Test File Failed");
          this.fullscreenLoading = false;
        });
    },
    pychange(file, fileList) {
      this.pyfile = fileList;
    },
    tsvChange(file, fileList, item) {
      item.tsvfile = fileList;
    },
    type2add() {
      let obj = {
        tsvfile: [],
      };
      this.type2List.push(obj);
    },
    type2delete() {
      this.type2List.pop();
    },
    submitSubmission(mode) {
      if (this.state == "not login") {
        this.$message.error("Please Login First");
        return;
      }
      if (this.description == "") {
        this.$message.error("Model Description Cannot be null");
        return;
      }
      if (this.institute == "") {
        this.$message.error("Affiliation Cannot be null");
        return;
      }
      if (this.submitionname == "") {
        this.$message.error("Submission Name Cannot be null");
        return;
      }

      if (this.fileList.length == 0) {
        this.$message.error("Test File Cannot be null");
        return;
      }

      for (let i = 0; i < this.paperList.length; i++) {
        if (this.paperList[i].paperModel == this.submitionname) {
          this.$message.error("Name Already Exist");
          return;
        }
      }

      for (let i = 0; i < this.submissionList.length; i++) {
        if (this.submissionList[i].submissionName == this.submitionname) {
          this.$message.error("Name Already Exist");
          return;
        }
      }

      let f = new FormData();
      let flops = [];
      let params = [];
      for (let i = 0; i < this.form.length; i++) {
        if (
          !this.isNumber(this.form[i].flops) ||
          !this.isNumber(this.form[i].params)
        ) {
          this.$message.error("Performance Must Be Number");
          return;
        }
      }

      this.form.forEach((item) => {
        flops.push(item.flops);
        params.push(item.params);
      });
      this.fileList.forEach((item) => {
        f.append("file", item.raw);
      });

      f.append("flops", flops.toString());
      f.append("params", params.toString());
      f.append("modelDescription", this.description);
      f.append("institute", this.institute);
      f.append("datasetId", this.currentDataset.datasetId);
      f.append("token", this.token);
      f.append("submissionName", this.submitionname);
      f.append("mode", mode);

      this.fullscreenLoading = true;
      axios({
        method: "post",
        url: "http://101.34.210.253:8081/submit/submitSubmission",
        headers: {
          "Content-Type": "multipart/form-data",
        },
        data: f,
      })
        .then((response) => {
          this.submitfileVisible = false;
          this.fileList = [];
          this.form = [];
          this.description = "";
          this.institute = "";
          this.submitionname = "";
          this.getSubmissionByDataset();
          this.fullscreenLoading = false;
          if (response.data.code == "500") {
            this.$message.error("Submit Test File Failed");
          } else if (response.data.code == "200"){
            this.$message.error("Submit test file success, the score of your model is " + response.data.score);
          }
        })
        .catch((error) => {
          //console.log(error);
          this.$message.error("Submit Test File Failed");
          this.fullscreenLoading = false;
        });
    },

    handleRemove(file, fileList) {
      let i = 0;
      for (; i < this.form.length; i++) {
        const element = this.form[i];
        if (element.file == file.name) break;
      }
      this.form.splice(i, 1);
      this.fileList.splice(i, 1);
    },
    handleChange(file, fileList) {
      if (this.fileList.length < fileList.length) {
        let obj = {
          file: file.name,
          params: "",
          flops: "",
        };
        this.form.push(obj);
        this.fileList = fileList;
      }
    },
    showSubmitFile() {
      this.submitfileVisible = true;
    },
    isNumber(val) {
      var regPos = /^\d+(\.\d+)?$/; //非负浮点数
      var regNeg =
        /^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/; //负浮点数
      if (regPos.test(val) || regNeg.test(val)) {
        return true;
      } else {
        return false;
      }
    },
    submitPaper() {
      if (this.state == "not login") {
        this.$message.error("Please Login First");
        return;
      }
      if (this.papername == "") {
        this.$message.error("Model Name Cannot be null");
        return;
      }
      if (this.papertitle == "") {
        this.$message.error("Paper Title Cannot be null");
        return;
      }
      if (this.paperwebsite == "") {
        this.$message.error("Paper URL Cannot be null");
        return;
      }
      if (this.papercode == "") {
        this.$message.error("Code URL Cannot be null");
        return;
      }

      for (let i = 0; i < this.paperList.length; i++) {
        if (this.paperList[i].paperModel == this.papername) {
          this.$message.error("Name Already Exist");
          return;
        }
      }

      for (let i = 0; i < this.submissionList.length; i++) {
        if (this.submissionList[i].submissionName == this.papername) {
          this.$message.error("Name Already Exist");
          return;
        }
      }
      let remark = [];
      let flops = [];
      let params = [];
      for (let i = 0; i < this.newModels.length; i++) {
        const element = this.newModels[i];
        if (
          !this.isNumber(element.remark) ||
          !this.isNumber(element.flops) ||
          !this.isNumber(element.params)
        ) {
          this.$message.error("Performance Must Be Number");
          return;
        }

        remark.push(element.remark);
        flops.push(element.flops);
        params.push(element.params);
      }
      this.fullscreenLoading = true;
      let data = {
        codeUrl: "http://" + this.papercode,
        modelName: this.papername,
        paperTitle: this.papertitle,
        paperUrl: "http://" + this.paperwebsite,
        token: this.token,
        datasetId: this.currentDataset.datasetId,
        remark: remark.toString(),
        flops: flops.toString(),
        params: params.toString(),
      };
      SubmitPaper(data)
        .then((response) => {
          this.submitPaperVisble = false;
          this.getPaperByDataset();
          this.papercode = "";
          this.papername = "";
          this.papertitle = "";
          this.paperwebsite = "";
          this.newModels = [
            {
              remark: "",
              flops: "",
              params: "",
            },
          ];
          this.fullscreenLoading = false;
        })
        .catch((error) => {
          //console.log(error);
          this.$message.error("Submit Paper Failed");
          this.fullscreenLoading = false;
        });
    },
    addModel() {
      let obj = {
        remark: "",
        params: "",
        flops: "",
      };
      this.newModels.push(obj);
    },
    deleteModel() {
      this.newModels.pop();
    },
    showSubmitPaper() {
      this.submitPaperVisble = true;
    },
    toPage(url) {
      window.location.href = url;
    },
    getFile() {
      window.location.href = this.currentDataset.testsetUrl;
    },
    getModelByPaperList() {
      let array = [];
      for (let index = 0; index < this.paperList.length; index++) {
        let element = this.paperList[index];
        array.push(element.paperId);
      }
      if (array.length > 0) {
        let data = {
          paperList: array.toString(),
        };
        GetModelByPaperList(data)
          .then((response) => {
            this.models = response.data.modellist;
            this.$refs.paperTable.toggleAllSelection();
          })
          .catch((error) => {
            //console.log(error);
          });
      }
    },

    getSubmitBySubmissionList() {
      let array = [];
      for (let index = 0; index < this.submissionList.length; index++) {
        const element = this.submissionList[index];
        array.push(element.submissionId);
      }
      let data = {
        submissionList: array.toString(),
      };
      GetSubmitBySubmissionList(data)
        .then((response) => {
          this.submits = response.data.submitlist;
        })
        .catch((error) => {
          //console.log(error);
        });
    },
    getRowClass({ row, column, rowIndex, columnIndex }) {
      return "background:#13227A;color:#fff";
    },
    handleEdit(index, row) {
      //console.log(index, row);
    },
    handleDelete(index, row) {
      //console.log(index, row);
    },
    getPaperByDataset: function () {
      let data = {
        datasetId: this.currentDataset.datasetId,
      };
      GetPaperByDataset(data)
        .then((response) => {
          this.paperList = response.data.paperlist;

          if (this.paperList.length > 0) this.getModelByPaperList();

          this.loadingPaper = false;
        })
        .catch((error) => {
          //console.log(error);
        });
    },
    initG1(data) {
      // 基于准备好的dom，初始化echarts实例
      this.myChart = echarts.init(document.getElementById("g1"));
      // 指定图表的配置项和数据
      let option = {
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "cross",
            label: {
              backgroundColor: "#6a7985",
            },
          },
        },
        legend: {
          data: this.legendData,
        },
        toolbox: {},
        grid: {
          left: "3%",
          right: "4%",
          bottom: "3%",
          containLabel: true,
        },
        xAxis: [
          {
            name: this.xName,
            type: "value",
          },
        ],
        yAxis: [
          {
            name: this.currentDataset.datasetEvalution,
            type: "value",
          },
        ],
        series: this.seriesData,
      };

      // 使用刚指定的配置项和数据显示图表。
      this.myChart.setOption(option);
    },

    drawG1(data) {
      let xname = this.xName;
      let perfor = this.currentDataset.datasetEvalution;
      if (xname == "FLOPs") {
        xname = "FLOPs(M)";
      } else {
        xname = "params(M)";
      }
      // 指定图表的配置项和数据
      let option = {
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "cross",
            label: {
              backgroundColor: "#6a7985",
            },
          },
          formatter: function (a) {
            let list = [];
            let listItem = "";
            for (var i = 0; i < a.length; i++) {
              list.push(
                '<i style="display: inline-block;width: 10px;height: 10px;background: ' +
                  a[i].color +
                  ';margin-right: 5px;border-radius: 50%;}"></i><span style="width:200px; display:inline-block;text-align:left">' +
                  a[i].seriesName +
                  "</span><br>" +
                  perfor +
                  " : " +
                  a[i].value[1] +
                  "<br>" +
                  xname +
                  " : " +
                  a[i].value[0]
              );
            }
            listItem = list.join("<br>");
            return '<div class="showBox">' + listItem + "</div>";
          },
        },
        legend: {
          data: this.legendData,
        },
        toolbox: {},
        grid: {
          left: "3%",
          right: "4%",
          bottom: "3%",
          containLabel: true,
        },
        xAxis: [
          {
            name: this.xName,
            type: "value",
            min: parseInt(this.xmin - 5),
            max: parseInt(this.xmax + 5),
          },
        ],
        yAxis: [
          {
            name: this.currentDataset.datasetEvalution,
            type: "value",
            min: parseInt(this.min - 5),
            max: parseInt(this.max + 5),
          },
        ],
        series: this.seriesData,
      };

      // 使用刚指定的配置项和数据显示图表。
      this.myChart.setOption(option);
    },
    getSubmissionByDataset: function () {
      let data = {
        datasetId: parseInt(this.currentDataset.datasetId),
      };
      GetSubmissionByDataset(data)
        .then((response) => {
          this.submissionList = response.data.submissionlist;
          if (this.submissionList.length > 0) this.getSubmitBySubmissionList();
          this.loadingSubmission = false;
          this.loading.close();
        })
        .catch((error) => {
          //console.log(error);
        });
    },
    handlePaperSelectionChange(val) {
      if (val.length > this.limitNum - this.seriesData.length) {
        this.limitpaperFn(val);
        return;
      }
      this.multiplePaperSelection = val;
      this.redrawG1();
    },
    redrawG1() {
      this.legendData = [];
      this.seriesData = [];
      this.myChart.clear();
      this.min = 110;
      this.max = 0;
      this.xmax = 0;
      this.xmin = 9999999999;
      // 遍历所选位置的paper
      for (let i = 0; i < this.multiplePaperSelection.length; i++) {
        let j = 0;
        const element = this.multiplePaperSelection[i];

        // 查找所选位置在paperlist的哪个索引，将其model name 加入legend
        for (; j < this.paperList.length; j++) {
          const e = this.paperList[j];

          if (e.paperId == element.paperId && this.models[j].length > 0) {
            break;
          }
        }
        let data = [];
        if (this.xName == "FLOPs") {
          for (let k = 0; k < this.models[j].length; k++) {
            let min = this.models[j][k].modelFlops;
            let minIndex = k;
            for (let w = k + 1; w < this.models[j].length; w++) {
              if (this.models[j][w].modelFlops < min) {
                min = this.models[j][w].modelFlops;
                minIndex = w;
              }
            }
            let temp = this.models[j][k];
            this.models[j][k] = this.models[j][minIndex];
            this.models[j][minIndex] = temp;
          }
        } else {
          for (let k = 0; k < this.models[j].length; k++) {
            let min = this.models[j][k].modelParams;
            let minIndex = k;
            for (let w = k + 1; w < this.models[j].length; w++) {
              if (this.models[j][w].modelParams < min) {
                min = this.models[j][w].modelParams;
                minIndex = w;
              }
            }
            let temp = this.models[j][k];
            this.models[j][k] = this.models[j][minIndex];
            this.models[j][minIndex] = temp;
          }
        }

        // 将所选位置的全部model加入曲线图中
        for (let k = 0; k < this.models[j].length; k++) {
          const e1 = this.models[j][k];
          let array = [];
          if (this.xName == "FLOPs") {
            array.push(e1.modelFlops);
            array.push(e1.modelRemark);
            if (e1.modelFlops > this.xmax) this.xmax = e1.modelFlops;
            if (e1.modelFlops < this.xmin) this.xmin = e1.modelFlops;
          } else {
            array.push(e1.modelParams);
            array.push(e1.modelRemark);
            if (e1.modelParams > this.xmax) this.xmax = e1.modelParams;
            if (e1.modelParams < this.xmin) this.xmin = e1.modelParams;
          }
          if (e1.modelRemark > this.max) this.max = e1.modelRemark;
          if (e1.modelRemark < this.min) this.min = e1.modelRemark;
          data.push(array);
        }
        // 加入曲线图并绘图
        let obj = {
          name: this.paperList[j].paperModel,
          type: "line",
          smooth: true,
          data: data,
        };
        this.legendData.push(this.paperList[j].paperModel);
        this.seriesData.push(obj);
      }
      for (let i = 0; i < this.multipleSubmissionSelection.length; i++) {
        let j = 0;
        const element = this.multipleSubmissionSelection[i];
        // 查找所选位置在paperlist的哪个索引，将其model name 加入legend
        for (; j < this.submissionList.length; j++) {
          const e = this.submissionList[j];

          if (
            e.submissionId == element.submissionId &&
            this.submits[j].length > 0
          ) {
            break;
          }
        }
        let data = [];
        // 将所选位置的全部model加入曲线图中
        if (this.xName == "FLOPs") {
          for (let k = 0; k < this.submits[j].length; k++) {
            let min = this.submits[j][k].submitFlops;
            let minIndex = k;
            for (let w = k + 1; w < this.submits[j].length; w++) {
              if (this.submits[j][w].submitFlops < min) {
                min = this.submits[j][w].submitFlops;
                minIndex = w;
              }
            }
            let temp = this.submits[j][k];
            this.submits[j][k] = this.submits[j][minIndex];
            this.submits[j][minIndex] = temp;
          }
        } else {
          for (let k = 0; k < this.submits[j].length; k++) {
            let min = this.submits[j][k].submitParams;
            let minIndex = k;
            for (let w = k + 1; w < this.submits[j].length; w++) {
              if (this.submits[j][w].submitParams < min) {
                min = this.submits[j][w].submitParams;
                minIndex = w;
              }
            }
            let temp = this.submits[j][k];
            this.submits[j][k] = this.submits[j][minIndex];
            this.submits[j][minIndex] = temp;
          }
        }

        for (let k = 0; k < this.submits[j].length; k++) {
          const e1 = this.submits[j][k];
          let array = [];
          if (this.xName == "FLOPs") {
            array.push(e1.submitFlops);
            array.push(parseFloat(e1.submitRemark));
            if (e1.submitFlops > this.xmax) this.xmax = e1.submitFlops;
            if (e1.submitFlops < this.xmin) this.xmin = e1.submitFlops;
          } else {
            array.push(e1.submitParams);
            array.push(parseFloat(e1.submitRemark));
            if (e1.submitParams > this.xmax) this.xmax = e1.submitParams;
            if (e1.submitParams < this.xmin) this.xmin = e1.submitParams;
          }
          data.push(array);
          if (parseFloat(e1.submitRemark) > this.max)
            this.max = parseFloat(e1.submitRemark);
          if (parseFloat(e1.submitRemark) < this.min)
            this.min = parseFloat(e1.submitRemark);
        }
        // 加入曲线图并绘图
        let obj = {
          name: this.submissionList[j].submissionName,
          type: "line",
          smooth: true,
          data: data,
        };

        this.legendData.push(this.submissionList[j].submissionName);

        this.seriesData.push(obj);
      }
      this.drawG1();
    },
    handleSubmissionSelectionChange(val) {
      if (val.length > this.limitNum - this.seriesData.length) {
        this.limitsubmissionFn(val);
        return;
      }
      this.multipleSubmissionSelection = val;
      this.redrawG1();
    },
    toLandingPage: function () {
      this.$router.replace("/");
    },
    chooseDataset(command) {
      this.currentDataset = command;
      this.loadingPaper = true;
      this.loadingSubmission = true;
      this.getPaperByDataset();
      this.getSubmissionByDataset();
      // this.$refs.paperTable.toggleAllSelection();
      // this.$refs.submissionTable.toggleAllSelection();
      this.drawG1();
    },
    chooseXName(command) {
      this.xName = command;
      this.redrawG1();
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
          window.localStorage.setItem("token", response.data.token);
          window.localStorage.setItem("username", response.data.username);
          this.state = "login";
          this.email = "";
          this.pwd = "";
          this.dialogVisible = false;
          this.token = response.data.token;
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
    getDatasetByTask: function () {
      let data = {
        taskId: parseInt(this.$route.query.taskId),
      };

      GetDatasetByTask(data)
        .then((response) => {
          this.datasets = response.data.datasetlist;
          this.currentDataset = this.datasets[0];
          this.getSubmissionByDataset();
          this.getPaperByDataset();
          this.initG1();
        })
        .catch((error) => {
          //console.log(error);
        });
    },
    getTaskById: function () {
      let data = {
        taskId: parseInt(this.$route.query.taskId),
      };

      GetTaskById(data)
        .then((response) => {
          this.task = response.data.task;
        })
        .catch((error) => {
          //console.log(error);
        });
    },
    handleCommand(command) {
      this.state = "not login";
      this.token = "";
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
    if (window.localStorage.getItem("token") != null) {
      this.state = "login";
      this.token = window.localStorage.getItem("token");
    } else this.state = "not login";
    this.task = this.$route.query.taskId;

    this.getTaskById();
  },
  mounted() {
    this.getDatasetByTask();
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

.el-footer {
  background-color: #13227a;
  color: #ffffff;
}

.logo {
  cursor: pointer;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.el-dropdown {
  vertical-align: top;
}
.el-dropdown + .el-dropdown {
  margin-left: 15px;
}
.el-icon-arrow-down {
  font-size: 12px;
}

.table-wrapper /deep/ .el-table--fit {
  padding: 20px;
}
.table-wrapper /deep/ .el-table,
.el-table__expanded-cell {
  background-color: transparent;
}

.table-wrapper /deep/ .el-table tr {
  background-color: transparent !important;
}
.table-wrapper /deep/ .el-table--enable-row-transition .el-table__body td,
.el-table .cell {
  background-color: transparent;
}
</style>
