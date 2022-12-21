.<template>
  <div class="content">
    <RegisterComp></RegisterComp>
  </div>
</template>

<script>
import RegisterComp from "../components/RegisterComp.vue";
export default {
    name: "RegisterPage",
    components:{
        RegisterComp,
    }

}
</script>

<style scoped>
.content{
  height: 100vh;
}

</style>