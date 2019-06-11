var vue = new Vue({
    el: "#app",
    data: {
        user: {id: "", username: "aaa", password: "", age: "", sex: "", email: ""},
        userList: []
    },
    methods: {
        findAll: function () {
            axios.get("/user/findAll").then(function (response) {
                vue.userList = response.data;
            }).catch(function (reason) {
                console.log(reason)
            })
        },
        findById:function (id) {
            axios.get("/user/findById/"+id).then(function (response) {
                vue.user = response.data;
            }).catch(function (reason) {
                console.log(reason)
            })

        },
        update:function () {
            axios.post("/user/update",vue.user).then(function (response) {
                vue.findAll();
            }).catch(function (reason) {
                console.log(reason)
            })
        }
    },
    created() {
        this.findAll();
    }
});