import ACCESS_ENUM from "@/access/accessEnum";
/**
 * Check access
 * @param loginUser 当前登录用户
 * @param needAccess 需要访问权限
 * @return boolean 是否有访问权限
 */
const checkAccess = (loginUser: any, needAccess = ACCESS_ENUM.NOT_LOGIN) => {
  const loginUserAccess = loginUser?.userRole ?? ACCESS_ENUM.NOT_LOGIN;
  if (needAccess === ACCESS_ENUM.NOT_LOGIN) {
    // 未登录,游客权限
    return true;
  }

  // 用户登录权限
  if (needAccess === ACCESS_ENUM.USER) {
    return loginUserAccess !== ACCESS_ENUM.NOT_LOGIN;
  }

  // 管理员权限
  if (needAccess === ACCESS_ENUM.ADMIN) {
    return loginUserAccess === ACCESS_ENUM.ADMIN;
  }
};

export default checkAccess;
