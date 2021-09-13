<template>
    
</template>

<script>
import {getList} from "@/api/indent"

export default {
    data() {
        return {

        }
    },
    methods: {
        find(){
            getList().then(res =>{
                console.log("res:",res)
            }),err=>{
            console.log("err:",err);
        }
        }
    },
    created: function(){
        this.find();
     },
    // mounted: function(){
    //     getList().then(res =>{
    //         console.log("api tableDate :",res);
    //     }),err=>{
    //         console.log("err:",err);
    //     }
    // }
}
</script>

<style>

</style>
