<template>
  <div>
    我是test页面
  </div>
</template>

<script>
export default {
  name: 'test',

  data() {
    return {
      //可以对指定属性或data数组进行数据传递在页面中显示
    };
  },

  mounted() {
    //在这发起后端请求，拿回数据，配合路由钩子做一些事情,也可以在打开当前页面执行methods里面的方法，例如：
    this.test()
  },

  methods: {
    //这里是写各种不同的方法函数，这些方法可以理解为是一个属性，因为调用这个方法的时候，最终返回的是一个值
    test(){
      console.log("hello")
    }
  },
};
</script>

<style lang="scss" scoped>

</style>
