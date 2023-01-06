<template>
    <div>
        <div>
            <button @click="selectUploadFile()">이미지 선택</button>
<<<<<<< HEAD
            <img src=http://localhost:8080/api/file/25e70fd8-e58f-46ad-a994-0e740f935ecc.png />
            <button @click="check()">확인</button>
=======
        </div>

        <div>
            <img v-if="isPreview" :src="imgSrc"/>
>>>>>>> acd1b888405e4fe332a5db20675a308f378f048f
        </div>
        
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'CorsReuqest',
    data() {
        return {
<<<<<<< HEAD
            response: '',
            img : false,
            imgSrc : 'test'
=======
            isPreview : false,
            imgSrc : 'http://localhost:3000',
>>>>>>> acd1b888405e4fe332a5db20675a308f378f048f
        }
    },
    methods: {
        selectUploadFile() {
            var data = this
            let elem = document.createElement('input')
            
            elem.id = 'image'
            elem.type = 'file'
            elem.accept = 'image/*'
            elem.multiple = false
            elem.click();

            elem.onchange = function() {
                const formData = new FormData()
<<<<<<< HEAD
                for (var index = 0; index < this.files.length; index++) {
                    formData.append('file', this.files[index])
                }
                axios.post('/api/file/upload', formData, { headers: { 'Content-Type': 'multipart/form-data' } }).then(response => {
                    vue.response = response.data
                    this.imgSrc = 'http://localhost:3000/api/file/'+response.data.fileName
                    alert(this.imgSrc)
                    this.img = true
=======
                formData.append('file', this.files[0])
                axios.post('/api/file/upload', formData, { headers: { 'Content-Type': 'multipart/form-data' } })
                .then(response => {
                    data.imgSrc += response.data.fileName
                    data.isPreview = true
>>>>>>> acd1b888405e4fe332a5db20675a308f378f048f
                }).catch(error => {
                    alert(error)
                })
            }
        },
<<<<<<< HEAD
        check(){
            alert(this.imgSrc)
        }
=======
>>>>>>> acd1b888405e4fe332a5db20675a308f378f048f
    }
}
</script>