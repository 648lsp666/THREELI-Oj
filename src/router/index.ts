import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import HomeView from "../views/HomeView.vue";
import ACCESS_ENUM from "@/access/accessEnum";
import UserLayout from "../../layouts/UserLayout.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/user",
    name: "user",
    meta: {
      access: ACCESS_ENUM.NOT_LOGIN,
      hideInMenu: true,
    },
    children: [
      {
        path: "/user/login",
        name: "login",
        component: () =>
          import(/* webpackChunkName: "about" */ "../views/User/LoginView.vue"),
        props: {},
        meta: {
          access: ACCESS_ENUM.NOT_LOGIN,
          hideInMenu: true,
        },
      },
      {
        path: "/user/register",
        name: "register",
        component: () =>
          import(
            /* webpackChunkName: "about"*/ "../views/User/RegisterView.vue"
          ),
        meta: {
          access: ACCESS_ENUM.NOT_LOGIN,
          hideInMenu: true,
        },
      },
    ],
  },
  {
    path: "/",
    name: "home",
    component: HomeView,
    meta: {
      access: ACCESS_ENUM.NOT_LOGIN,
    },
  },
  {
    path: "/admin",
    name: "admin",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AdminView.vue"),
    meta: {
      access: ACCESS_ENUM.ADMIN,
    },
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
    props: {},
    meta: {
      access: ACCESS_ENUM.NOT_LOGIN,
    },
  },
  {
    path: "/noauth",
    name: "noauth",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/NoAuthView.vue"),
    props: {},
    meta: {
      access: ACCESS_ENUM.NOT_LOGIN,
      hideInMenu: true,
    },
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
