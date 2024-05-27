export const deepCopy = (obj: any, hash = new WeakMap()): any => {
  // 基本类型直接返回
  if (obj === null || typeof obj !== "object") {
    return obj;
  }
  // 如果对象已经被复制过，则直接返回引用，处理循环引用
  if (hash.has(obj)) {
    return hash.get(obj);
  }

  // 初始化新对象/数组
  let newObj: any;
  if (Array.isArray(obj)) {
    newObj = [];
  } else if (obj instanceof Set) {
    newObj = new Set();
  } else if (obj instanceof Map) {
    newObj = new Map();
  } else {
    newObj = {};
  }

  // 保存到哈希表中
  hash.set(obj, newObj);

  if (Array.isArray(obj)) {
    // 处理数组
    obj.forEach((item, index) => {
      newObj[index] = deepCopy(item, hash);
    });
  } else if (obj instanceof Set) {
    // 处理 Set
    obj.forEach((item) => {
      newObj.add(deepCopy(item, hash));
    });
  } else if (obj instanceof Map) {
    // 处理 Map
    obj.forEach((value, key) => {
      newObj.set(key, deepCopy(value, hash));
    });
  } else {
    // 处理普通对象
    Object.keys(obj).forEach((key) => {
      newObj[key] = deepCopy(obj[key], hash);
    });
  }

  return newObj;
};
