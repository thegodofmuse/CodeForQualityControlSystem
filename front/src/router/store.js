import { createStore } from 'vuex'


const store = createStore({
    state: {
        // 在这里定义你的共享状态
        currentPage: 1, // 默认当前页为1
    },
    getters: {
        // 在这里定义你的获取器方法
        currentPage: state => state.currentPage,
    },
    mutations: {
        // 在这里定义你的变更方法
        setCurrentPage(state, page) {
            state.currentPage = page;
        },
    },
});

export default store;

