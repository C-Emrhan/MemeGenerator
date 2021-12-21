<template>
  <body>
  <h1 id="h1">Discover Your Memes</h1>
  <div id="slide">
    <span v-for="createdMeme in createdMemes" :key="createdMeme.id">
      <input type="image" :src="createdMeme.url" width="300" height="300">
    </span>
  </div>
  </body>
</template>

<script>
export default {
  name: 'Discover',
  data () {
    return {
      createdMemes: []
    }
  },
  mounted () {
    const requestOptions2 = {
      method: 'GET',
      redirect: 'follow'
    }
    const endpoint2 = process.env.VUE_APP_BACKEND_BASE_URL + '/api/v1/created'
    fetch(endpoint2, requestOptions2)
      .then(response => response.json())
      .then(result => result.forEach(createdMemes => {
        this.createdMemes.push(createdMemes)
      }))
      .catch(error => console.log('error', error))
  }
}
</script>

<style scoped>
#h1 {
  font-size: 100px;
  font-family: "Bauhaus 93";
  color: white;
  position: absolute;
  right: 260px;
  top: 100px;
}
#slide {
  width: 1000px;
  margin: 0 auto;
  height: 319px;
  overflow-x: scroll;
  overflow-y: hidden;
  white-space: nowrap;
  position: absolute;
  right: 220px;
  top: 350px;
}
</style>
