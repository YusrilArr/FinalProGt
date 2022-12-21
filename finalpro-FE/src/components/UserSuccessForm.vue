.<template>
  <div class="card-body border-color-pink">
    <h5 class="card-title">Berhasil!</h5>
    <p class="card-text">Data Anda Berhasil Ditambahkan !!!</p>
    <router-link to="/LoginPage" class="btn bg-color-pink text-dark"
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
.bg-color-pink {
  background-color: #5117d6;
}
</style>