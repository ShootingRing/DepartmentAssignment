import {createRouter, createWebHashHistory} from 'vue-router'

const home = () => import('src/components/home.vue')
const notFound = () => import('~/components/404.vue')

const routes = [
    {
        path: '/',
        redirect: '/login'
    },
    {
        path: '/home',
        name: 'home',
        component: home
    },
    {
        path: '/:pathMatch(.*)*',
        name: 'not-found',
        component: notFound
    },

]

const router = createRouter({
    history: createWebHashHistory(),
    routes,
})

export default router
