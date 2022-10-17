import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)

const routes = [{
        path: '/',
        redirect: "landing"
    },

    {
        path: '/landing',
        name: 'landing',
        component: () =>
            import ('../views/landingPage/index.vue'),
        meta: {
            keepAlive: false,
            title: 'ELUE Benchmark'
        }
    },

    {
        path: '/about',
        name: 'about',
        component: () =>
            import ('../views/aboutPage/index.vue'),
        meta: {
            keepAlive: true, // 需要被缓存
            title: 'ELUE Benchmark'
        }
    },
    {
        path: '/leaderboard',
        name: 'leaderboard',
        component: () =>
            import ('../views/leaderboardPage/index.vue'),
        meta: {
            keepAlive: false, // 需要被缓存
            title: 'ELUE Benchmark'
        }
    },
    {
        path: '/profile',
        name: 'profile',
        component: () =>
            import ('../views/profilePage/index.vue'),
        meta: {
            keepAlive: false, // 需要被缓存
            title: 'ELUE Benchmark'
        }
    },

    {
        path: '/task',
        name: 'task',
        component: () =>
            import ('../views/taskPage/index.vue'),
        meta: {
            keepAlive: false, // 需要被缓存
            title: 'ELUE Benchmark'
        }
    },


]

const router = new VueRouter({
    routes
})

export default router