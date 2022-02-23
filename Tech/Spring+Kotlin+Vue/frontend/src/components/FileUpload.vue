<template>
    <div>
        <div>
            <button @click="selectUploadFile()">이미지 선택</button>
        </div>

        <div>
            <img v-if="isPreview" :src="imgSrc"/>
        </div>
        
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'CorsReuqest',
    data() {
        return {
            isPreview : false,
            imgSrc : 'http://localhost:3000',
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
                formData.append('file', this.files[0])
                axios.post('/api/file/upload', formData, { headers: { 'Content-Type': 'multipart/form-data' } })
                .then(response => {
                    data.imgSrc += response.data.fileName
                    data.isPreview = true
                }).catch(error => {
                    alert(error)
                })
            }
        },
    }
}
</script>