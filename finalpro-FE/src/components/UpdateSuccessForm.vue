.<template>
  <div class="card-body border-color-pink ml-5 mt-3 mr-4">
    <h5 class="card-title">Berhasil!</h5>
    <p class="card-text">Data Anda Berhasil Diupdate !!!</p>
    <router-link to="/home" class="btn btn-primary"
      >OK</router-link
    >
  </div>
</template>

<script>
export default {};
</script>

<style>
.border-color-pink {
  border: solid 2px #0c2ec7;
}

</style>