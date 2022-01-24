<template>
    <div>
        <!-- <h3>파일 업로드 결과: { { this.response === '' ? 'waiting' : this.response } }</h3> -->
        <div>
            <button @click="selectUploadFile()">이미지 선택</button>
        </div>

        <div>
            <img v-bind:src="imgSrc"/>
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
            imgSrc : ''
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
            elem.multiple = true
            // 클릭
            elem.click();
            // 이벤트 감지
            elem.onchange = function() {
                const formData = new FormData()
                for (var index = 0; index < this.files.length; index++) {
                    formData.append('fileList', this.files[index])
                }
                axios.post('/api/file/upload', formData, { headers: { 'Content-Type': 'multipart/form-data' } }).then(response => {
                    vue.response = response.data
                    // alert(elem.files[0].name)
                    // this.imgSrc = "../../../backend/src/images/"+ elem.files[0].name
                    this.imgSrc = "http://localhost:8080/file/" + elem.files[0].name
                    this.img = true;
                    // alert(this.imgSrc)
                    // alert(this.img)
                    alert(response.data.message)
                })
            }
        }
    }
}
</script>