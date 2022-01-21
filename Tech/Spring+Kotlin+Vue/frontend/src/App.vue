<template>
  <div>
    <Header/>
    <div class="wrap">
      <!-- <Menu/>
      <Content/> -->
      <FileUpload/>
    </div>
  </div>
</template>

<script>
import Header from './components/Header.vue'
// import Menu from './components/Menu.vue'
// import Content from './components/Content.vue'
import FileUpload from './components/FileUpload.vue'

export default {
  name: 'App',
  components: {
    Header,
    // Menu,
    // Content
    FileUpload
  },
}
</script>

<style scoped>
.wrap {
  display: flex;
}
</style>
