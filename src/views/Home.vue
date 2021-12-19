<template>
  <div class="home">
    <body style="background-color: black">
    <div class="mm-text-wrap"><textarea placeholder="Text #2" id="tx0" class="mm-text" style="height: 44px; position: absolute;
       left: 535px; bottom: 300px"></textarea></div>
    <div class="mm-text-wrap"><textarea placeholder="Text #2" id="tx1" class="mm-text" style="height: 44px; position: absolute;
      left: 535px; bottom: 245px"></textarea></div>
    <div>&nbsp;</div>
    <div>
      <button style="position: absolute; left: 535px; bottom: 190px" type="button" class="btn btn-primary" id="btn" v-on:click="test">Generate</button>
      &nbsp;
      <button style="position: absolute; left: 640px; bottom: 190px" type="button" class="btn btn-secondary" v-on:click="resetpage">Reset</button>
    </div>
    </body>
  </div>
</template>

<script>
export default {
  name: 'Home'
}
</script>

<style>
</style>
