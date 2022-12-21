.<template>
  <div class="card-body border-color-pink">
    <h5 class="card-title">Berhasil!</h5>
    <p class="card-text">Pendaftaran Berhasil, Silahkan Log in</p>
    <router-link to="/Login" class="btn bg-color-pink text-dark"
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