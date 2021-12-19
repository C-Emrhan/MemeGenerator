<template>
  <div class="home">
    <body style="background-color: black">
    <div class="mm-text-wrap"><textarea placeholder="Text #2" id="tx0" class="mm-text" style="height: 44px; position: absolute;
       left: 535px; bottom: 300px"></textarea></div>
    <div class="mm-text-wrap"><textarea placeholder="Text #2" id="tx1" class="mm-text" style="height: 44px; position: absolute;
      left: 535px; bottom: 245px"></textarea></div>
    <div>&nbsp;</div>
    <div>&nbsp;</div>
    <div id="slide" style="position: absolute; left: 250px; bottom: 35px">
      <div v-for="meme in memes" :key="meme.id">
        <input type="image" :src="meme.url" v-on:click="seephoto(meme)" width="170" height="170">
      </div>
    </div>
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
  name: 'Home',
  data () {
    return {
      memes: []
    }
  },
  mounted () {
    const endpoint = process.env.VUE_APP_BACKEND_BASE_URL + '/api/v1/memetemplates'
    const requestOptions = {
      method: 'GET',
      redirect: 'follow'
    }

    fetch(endpoint, requestOptions)
      .then(response => response.json())
      .then(result => result.forEach(memes => {
        this.memes.push(memes)
      }))
      .catch(error => console.log('error', error))
  }
}
</script>

<style>
</style>
