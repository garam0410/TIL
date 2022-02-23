<template>
  <div>
    <Header/>
    <div class="wrap">
      <!-- <Menu/>
      <Content/> -->
      <FileUpload/>
      <Calendar/>
    </div>
  </div>
</template>

<script>
import Header from './components/Header.vue'
import FileUpload from './components/FileUpload.vue'
import Calendar from './components/Calendar.vue'

export default {
  name: 'App',
  components: {
    Header,
    // Menu,
    // Content
    FileUpload,
    Calendar
  },
}
</script>

<style scoped>
.wrap {
  display: flex;
}
</style>
