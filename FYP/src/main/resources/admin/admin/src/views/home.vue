<template>
    <div class="content"
        :style='{ "minHeight": "100vh", "width": "100%", "padding": "30px", 
        // "background": "url(https://cdn.pixabay.com/photo/2015/05/15/09/13/demonstration-767983_1280.jpg) no-repeat center 40px",
         "height": "auto" }'>
        <div class="text"
            :style='{ "margin": "30px auto", "color": "#fff", "textAlign": "center", "background": "none", "width": "100%", "fontSize": "32px", "lineHeight": "600px", "fontWeight": "bold", "height": "600px" }'>
            Welcome to use {{ this.$project.projectName }}</div>
    </div>
</template>
<script>
//0
import router from '@/router/router-static'
import * as echarts from 'echarts'
export default {
    data() {
        return {
        };
    },
    mounted() {
        this.init();
    },
    methods: {
        init() {
            if (this.$storage.get('Token')) {
                this.$http({
                    url: `${this.$storage.get('sessionTable')}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code != 0) {
                        router.push({ name: 'login' })
                    }
                });
            } else {
                router.push({ name: 'login' })
            }
        },
    }
};
</script>
<style lang="scss" scoped>
.cardView {
    display: flex;
    flex-wrap: wrap;
    width: 100%;

    .cards {
        display: flex;
        align-items: center;
        width: 100%;
        margin-bottom: 10px;
        justify-content: center;

        .card {
            width: calc(25% - 20px);
            margin: 0 10px;

            /deep/.el-card__body {
                padding: 0;
            }
        }
    }
}
</style>
