.<template>
<div class="bg-info h-100 d-flex align-items-center">
   <div>
      <img src="../assets/ktp.png" style="width:100vh;">
    </div>
  <div class="col-lg-4 col-md-6 col-sm-8 mx-auto">
    <div class="card register p-5 rounded bg-light d-flex justify-content-center">
        <h1>Sign Up</h1>
        <form @submit.prevent="inputUser" v-show="!success">
            <input v-model="userData.nama" type="text" class="form-control mb-4 mt-3" placeholder="Nama Lengkap" required>
            <input v-model="userData.email" type="email" class="form-control mb-4" placeholder="Email" required>
            <p v-show="check" class="font-weight-bold mt-0" style="color: red;">Maaf Email sudah terdaftar!</p>
            <input v-model="userData.password" id="password" type="password" class="form-control mb-4" placeholder="Password" required>
            <input v-model="userData.password2" id="password2"  type="password" class="form-control" placeholder="Confirm Password" required>
            <p v-show="checkPassword" class="font-weight-bold" style="color: red;">Password yang anda masukkan tidak sama!</p>
            
            <button class="btn btn-primary mb-2 mt-4" type="submit">
            Submit
            </button>
        </form>
            <p>Sudah punya akun kan? <a href="/Login">Masuk disini yagesya</a>
            </p>

        <SuccessRegister v-show="success"></SuccessRegister>

    </div>
  </div>

</div>
</template>

<script>
import userService from "../services/proService.js";
import SuccessRegister from "../components/SuccessRegister.vue"
export default {
    name: "RegisterComp",
    components:{
      SuccessRegister,
    },

    data(){
      return{
         userData:{
            nama: null,
            email: null,
            password: null,
            password2: null,
            },
            success: false,
            check: false,
            checkPassword: false,
        }
    },

    methods:{
      inputUser(){
      if(this.userData.password2 == this.userData.password){
         let data = this.userData;
         userService.createUser(data)
         .then((response) =>{
         console.log(response.data)
         this.success = true;
      })
         .catch((e) => {
         console.log(e)
         if(e.response.data.trace.includes("Duplicate entry")){
         this.check = true
         }
      });
      }else{
            this.checkPassword = true
         }

      },
    }

}
</script>

<style>

</style>