.<template>
  <div class="bg-info h-100 d-flex align-items-center">
    <div>
      <img src="../assets/ktp.png" style="width:100vh;">
    </div>
  <div class="col-lg-4 col-md-6 col-sm-8 mx-auto">
    <div class="card register p-5 rounded bg-light d-flex justify-content-center">
        <h1>Sign In</h1>
        <form @submit.prevent="loginUser">
            <input v-model="loginData.email" type="email" id="email_login" name="email" class="form-control mb-5" placeholder="Email" required>
            <input v-model="loginData.password" type="password" id="password_login" name="password" class="form-control mb-5 mt-3" placeholder="Password" required>
            <p v-show="check" class="font-weight-bold" style="color: red;">Email atau Password salah!</p>
            <button
              to="/Home"
              type="submit"
              tag="button"
              class="btn btn-primary mt-1 mb-2"
              >Log In</button
            >
            <p>Belum punya akun kan? <a href="/Register">Daftar Disini</a>
            </p>
        </form>

    </div>
  </div>

</div>
</template>

<script>
import proService from "../services/proService.js";

export default {
    name: "LoginComp",
    components:{

    },

    data(){
      return{
        loginData: {
          email: null,
          password: null,
        },
        check: false,

      };
    },

    methods:{
      loginUser(){
        let data = this.loginData;
        proService.getUser(data)
        .then((response) =>{
          console.log(response.data);
          this.$router.push("/Home")
        })
        .catch((e) =>{
          console.log(e)
          if(e.response.data.trace.includes("Incorrect result")){
            this.check = true;
          }
        });

      }
    }

}
</script>

<style scoped>
.input-group{
  position: relative;
}

input{
  border: solid 1.5px rgb(119, 7, 224);
  border-radius: 1rem;;
  background: none;
  padding: 1rem;
  font-size: 1rem;
  color: #f5f5f5;
  transition: 150ms cubic-bezier(0.5, 0, 0.2, 0);
}

label{
  font-size: 1.5rem;
  position: absolute;
  left: 16px;
  color: #e8e8e8;
  pointer-events: none;
  transform: translateY(2rem);
  transition: 150ms cubic-bezier(1, 0, 0.2, 1);

}

input:focus{
  outline: none;
  border: 1.5px solid #1a73e8;
}

input:focus ~ label{
  transform: translateY(-50%) scale(0.8);
  background-color: red;
  padding: 0 0.2em;
  color: #2196f3;
}

</style>