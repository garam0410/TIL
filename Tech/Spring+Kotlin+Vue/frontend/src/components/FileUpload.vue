<template>
    <div>
        <div>
            <button @click="selectUploadFile()">이미지 선택</button>
            <img src=http://localhost:8080/api/file/25e70fd8-e58f-46ad-a994-0e740f935ecc.png />
            <button @click="check()">확인</button>
        </div>
        
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'CorsReuqest',
    data() {
        return {
            response: '',
            img : false,
            imgSrc : 'test'
        }
    },
    methods: {
        selectUploadFile() {
            var vue = this
            let elem = document.createElement('input')
            // 이미지 파일 업로드 / 동시에 여러 파일 업로드
            elem.id = 'image'
            elem.type = 'file'
            elem.accept = 'image/*'
            elem.multiple = false
            // 클릭
            elem.click();
            // 이벤트 감지
            elem.onchange = function() {
                const formData = new FormData()
                for (var index = 0; index < this.files.length; index++) {
                    formData.append('file', this.files[index])
                }
                axios.post('/api/file/upload', formData, { headers: { 'Content-Type': 'multipart/form-data' } }).then(response => {
                    vue.response = response.data
                    this.imgSrc = 'http://localhost:3000/api/file/'+response.data.fileName
                    alert(this.imgSrc)
                    this.img = true
                }).catch(error => {
                    vue.response = error.response.data
                    alert(vue.response.message)
                })
            }
        },
        check(){
            alert(this.imgSrc)
        }
    }
}
</script>