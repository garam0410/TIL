<template>
  <YearCalendar
    v-model="year"
    :activeDates.sync="activeDates"
    @toggleDate="toggleDate"
    prefixClass="your_customized_wrapper_class"
    :activeClass="activeClass"
  ></YearCalendar>
</template>

<script>
import YearCalendar from "vue-material-year-calendar";

export default {
  components: { YearCalendar },
  data() {
    return {
      year: 2022,
      activeDates: [
        { date: "2019-02-13" },
        { date: "2019-02-14", className: "red" },
        { date: "2019-02-15", className: "blue" },
        { date: "2019-02-16", className: "your_customized_classname" },
      ],
      activeClass: "",
    };
  },
  methods: {
    toggleDate(dateInfo) {
      console.log(dateInfo); // { date: '2010-10-23', selected: true }
      console.log(this.activeClass);
    },
  },
};
</script>

<style lang="stylus">
.your_customized_wrapper_class
  background-color: #0aa
  color: white
  &.red
    background-color: red
    color: white
    &:after
      // background-image url('./assets/baseline-remove_circle-24px.svg')
      background-size 100% 100%
  &.blue
    background-color: #0000aa
    color: white
  &.your_customized_classname
    background-color: yellow
    color: black
</style>
