<template>
<h1>Discover Memes</h1>
  <body>
  <div id="slide" style="position: absolute; left: 250px; bottom: 35px">
    <div v-for="createdMeme in createdMemes" :key="createdMeme.id">
      <input type="image" :src="createdMeme.url" width="170" height="170">
    </div>
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

</style>
