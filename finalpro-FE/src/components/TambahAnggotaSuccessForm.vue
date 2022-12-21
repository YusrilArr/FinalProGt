.<template>
  <div class="card-body border-color-pink">
    <h5 class="card-title">Berhasil!</h5>
    <p class="card-text">Anggota Keluarga Berhasil Ditambahkan !!!</p>
    <router-link to="/Home" class="btn bg-color-pink text-dark"
      >OK</router-link
    >
  </div>
</template>

<script>
export default {};
</script>

<style>
.border-color-pink {
  border: solid 2px blue;
}
.bg-color-pink {
  background-color: blue;
}
</style>