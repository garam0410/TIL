<template>
    <div>
        <!-- <h3>파일 업로드 결과: { { this.response === '' ? 'waiting' : this.response } }</h3> -->
        <div>
            <button @click="selectUploadFile()">이미지 선택</button>
        </div>

        <div>
            <img src="http://localhost:8080/file/test.png"/>
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
            elem.multiple = false
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
                    alert(response.data[0].filePath)
                }).catch(error => {
                    vue.response = error.response.data
                    alert(vue.response.message)
                })
            }
        }
    }
}
</script>