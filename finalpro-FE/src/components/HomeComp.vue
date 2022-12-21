.<template>
  <div>
    <div v-show="!success">
    <div class="d-flex flex-row">
      <div
        class="card text-white bg-info mr-5 mb-3 ml-5 mt-3"
        style="max-width: 18rem; outline-style:outset"
      >
        <div class="card-header ">Jumlah Kartu Keluarga</div>
        <div class="card-body bg-light">
          <h5 class="card-title d-flex mt-2 justify-content-center" style="font-size:30px; color:teal;">{{kartuData.length}} KK</h5>
        </div>
      </div>

      <div
        class="card text-white bg-info mb-3 ml-5 mt-3"
        style="max-width: 18rem; outline-style:outset"
      >
        <div class="card-header">Jumlah Seluruh Warga</div>
        <div class="card-body bg-light">
          <h5 class="card-title d-flex mt-2 justify-content-center" style="font-size:30px; color:teal;">{{anggotaData.length}} Orang</h5>
        </div>
      </div>
    </div>

    <h1 class="d-flex justify-content-center mt-2">Data Kartu Keluarga</h1>
    <div class="mt-3 ml-5 mr-3 border border-primary">
      <table class="table table-striped">
        <thead class="table-info">
          <tr>
            <th scope="col">No</th>
            <th scope="col">Nomor KK</th>
            <th scope="col">Alamat</th>
            <th scope="col">Kota</th>
            <th scope="col">Kode Pos</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          <tr  v-for="(item, index) in kartuData" :key="index">
            <th scope="row">{{ index + 1 }}</th>
            <td>{{item.nomor_kk}}</td>
            <td>{{item.alamat}}</td>
            <td>{{item.kabupaten_kota}}</td>
            <td>{{item.kode_pos}}</td>
            <td>
              <router-link
                :to="{ path: '/Detail/' + item.id}"
                type="submit"
                class="btn btn-primary ml-3"
                >Detail</router-link
              >
              <button
              type="submit"
              class="btn btn-danger ml-3"
              @click.prevent="deleteKartu(item.id)"
            >
              Delete
            </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>

    </div>
  </div>
</template>

<script>
import kartuService from "../services/proService";
import DeleteSuccessForm from "../components/DeleteSuccessForm.vue";

export default {
  name: "HomeComp",
  data(){
    return{
      kartuData: [],
      anggotaData: [],
      success: false,
    };
  },

  component:{
    DeleteSuccessForm,
  },


  mounted(){
    this.getKartu();
    this.getAllAnggota();
  },
    methods: {
      getKartu(){
        kartuService.getAll()
        .then((response) => {
          this.kartuData = response.data;
          console.log(this.kartuData);
        })
        .catch((e) =>{
          console.log(e);
        });
      },

      getAllAnggota(){
        kartuService.getAllAnggota()
        .then((response) => {
          this.anggotaData = response.data;
          console.log(this.anggotaData);
        })
        .catch((e) =>{
          console.log(e);
        });
      },

      deleteKartu(id){
        if(confirm("Apakah anda yakin akan menghapus data ini ?")
        ){
          kartuService.delete(id)
          .then((response) => {
            console.log(response.data);
            this.success = true;
          })
          .catch((e) => {
            console.log(e);
          });
          location.reload();
        }
        
      }
    },


};
</script>

<style>
</style>