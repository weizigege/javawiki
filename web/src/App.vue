<template>
  <a-layout>
      <the-header></the-header>
      <router-view/>
      <the-footer></the-footer>
    </a-layout>

</template>
<!--引入the-header-->
<script lang="ts">
    import { defineComponent } from 'vue';
    import TheHeader from '@/components/the-header.vue';
    import TheFooter from '@/components/the-footer.vue';
    // import HelloWorld from "@/components/HelloWorld.vue"; // @ is an alias to /src

    export default defineComponent({
        name: 'app',
        components: {
            TheHeader,
            TheFooter
        },
    });
</script>



<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
