<template>
  <div class="home">
    <body>
    <div>
      <h1 id="h1">Meme Generator</h1>
      <h2 id="h2">by Caner and Emirhan</h2>
    </div>
    <div>
      <img id="loadingImage" width="350" height="350" src="https://i.imgflip.com/5yp3sr.jpg" alt="" style="position: absolute; right: 280px; bottom: 90px"/>
    </div>
    <div>&nbsp;</div>
    <div class="mm-text-wrap"><textarea placeholder="Text #2" id="tx0" class="mm-text" style="height: 44px; position: absolute;
       left: 535px; bottom: 300px"></textarea></div>
    <div class="mm-text-wrap"><textarea placeholder="Text #2" id="tx1" class="mm-text" style="height: 44px; position: absolute;
      left: 535px; bottom: 245px"></textarea></div>
    <div>&nbsp;</div>
    <div id="slide" style="position: absolute; left: 250px; bottom: 70px">
      <div v-for="meme in memes" :key="meme.id">
        <input type="image" :src="meme.url" v-on:click="seephoto(meme)" width="170" height="170">
      </div>
    </div>
    <div>&nbsp;</div>
    <div>
      <button style="position: absolute; left: 535px; bottom: 190px" type="button" class="btn btn-primary" id="btn" v-on:click="test">Generate</button>
      &nbsp;
      <button style="position: absolute; left: 640px; bottom: 190px" type="button" class="btn btn-secondary" v-on:click="resetpage">Reset</button>
    </div>
    <div>&nbsp;</div>
    <div>&nbsp;</div>
    <div>&nbsp;</div>
    <div>&nbsp;</div>
    <div>&nbsp;</div>
    <div>&nbsp;</div>
    <div>&nbsp;</div>
    <div>&nbsp;</div>
    </body>
  </div>
</template>

<script>
export default {
  name: 'Home',
  data () {
    return {
      memes: [],
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
  },
  methods: {
    resetpage: function () {
      window.location.reload()
    },
    seephoto: function (str) {
      document.getElementById('loadingImage').style.visibility = 'visible'
      document.getElementById('loadingImage').src = str.url
      document.getElementById('loadingImage').alt = str.id
    },
    test: function () {
      const myHeaders = new Headers()
      myHeaders.append('Content-Type', 'application/json')
      const raw = JSON.stringify({
        tx0: document.getElementById('tx0').value,
        tx1: document.getElementById('tx1').value,
        id: document.getElementById('loadingImage').alt,
        username: 'banana222',
        password: 'provaprova'
      })

      const requestOptions1 = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
      }
      const endpoint1 = process.env.VUE_APP_BACKEND_BASE_URL + '/api/v1/caption'
      fetch(endpoint1, requestOptions1)
        .then(response => response.json())
        .then(data => {
          document.getElementById('loadingImage').src = data.url
        })
        .catch(error => console.log('error', error))
    }
  }
}
</script>

<style>
#slide {
  width: 200px;
  margin: 0 auto;
  height: 400px;
  overflow-x: hidden;
  overflow-y: scroll;
  white-space: nowrap;
}
#h2{
  font-size: 50px;
  font-family: "Bauhaus 93";
  color: white;
  position: absolute;
  right: 475px;
  top: 210px;
}
#h1 {
  font-size: 100px;
  font-family: "Bauhaus 93";
  color: white;
  position: absolute;
  right: 350px;
  top: 100px;
}
body{
  background-image: url('https://wallpapercave.com/wp/wp6402819.jpg');
  background-size: cover;
}
</style>
