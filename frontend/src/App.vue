<template>
  <div id="app">
    <keep-alive>
      <router-view v-wechat-title="$route.meta.title" v-if="$route.meta.keepAlive"></router-view>
    </keep-alive>
    <router-view v-wechat-title="$route.meta.title" v-if="!$route.meta.keepAlive"></router-view>
  </div>
</template>

<style>
html,
body,
#app {
  height: 100%;
  padding: 0;
  margin: 0;
}
</style>
