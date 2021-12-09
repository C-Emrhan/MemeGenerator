<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <body>
    <div class="input-group flex-nowrap">
      <span class="input-group-text" id="addon-wrapping">@</span>
      <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
    </div>
    </body>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
