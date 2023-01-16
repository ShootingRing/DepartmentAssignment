import {createRouter, createWebHashHistory} from 'vue-router'

const home = () => import('~/components/home.vue')
const notFound = () => import('~/components/404.vue')

const routes = [
    {
        path: '/',
        redirect: '/home'
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
