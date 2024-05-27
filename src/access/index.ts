import router from "@/router";
import ACCESS_ENUM from "@/access/accessEnum";
import store from "@/store";
import checkAccess from "@/access/checkAccess";

router.beforeEach(async (to, from, next) => {
  // todo 获取用户信息
  let loginUser = store.state.user.loginUser;
  const needAccess = to.meta?.access ?? ACCESS_ENUM.NOT_LOGIN;
  console.log("needAccess", needAccess);
  console.log("loginUser", loginUser);
  /**
   * 如果不需要登录，直接跳转;
   * 如果需要登录，但是用户信息不存在，跳转到登录页
   * 如果用户信息存在，但是没有权限，跳转到无权限页
   */
  if (needAccess === ACCESS_ENUM.NOT_LOGIN) {
    next();
    return;
  } else {
    if (!loginUser || !loginUser.userRole) {
      await store.dispatch("user/getLoginUser");
      loginUser = store.state.user.loginUser;
      next(`/user/login?redirect=${to.fullPath}`);
    } else if (!checkAccess(loginUser, needAccess as string)) {
      next("/noauth");
    } else {
      next();
    }
  }
  /**
   * 如果用户信息不存在，获取用户信息
   */
  if (!loginUser || !loginUser.userRole) {
    await store.dispatch("user/getLoginUser");
  }
  if (!checkAccess(loginUser, needAccess as string)) {
    next("/login");
  } else {
    next();
  }
});
