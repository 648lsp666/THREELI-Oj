import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import HomeView from "../views/HomeView.vue";
import ACCESS_ENUM from "@/access/accessEnum";
import UserLayout from "../../layouts/UserLayout.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/user",
    name: "用户页",
    meta: {
      access: ACCESS_ENUM.NOT_LOGIN,
      hideInMenu: true,
    },
    children: [
      {
        path: "/user/login",
        name: "登录",
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
        name: "注册",
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
    path: "/question/add",
    name: "添加题目",
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/Question/admin/AddQuestionView.vue"
      ),
    meta: {
      access: ACCESS_ENUM.ADMIN,
    },
  },
  {
    path: "/question/manage",
    name: "管理题目",
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/Question/admin/ManageQuestionView.vue"
      ),
    meta: {
      access: ACCESS_ENUM.ADMIN,
    },
  },
  {
    path: "/question/update/:id",
    name: "修改题目",
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/Question/admin/UpdateQuestionView.vue"
      ),
    meta: {
      access: ACCESS_ENUM.ADMIN,
      hideInMenu: true,
    },
  },
  {
    path: "/",
    name: "主页",
    component: HomeView,
    meta: {
      access: ACCESS_ENUM.NOT_LOGIN,
    },
  },
  {
    path: "/admin",
    name: "管理员",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AdminView.vue"),
    meta: {
      access: ACCESS_ENUM.ADMIN,
    },
  },
  {
    path: "/problemset",
    name: "题库",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/Question/user/ProblemSetView.vue"
      ),
    props: {},
    meta: {
      access: ACCESS_ENUM.NOT_LOGIN,
    },
  },
  {
    path: "/noauth",
    name: "无权限",
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
