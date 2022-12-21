.<template>
  <div>
    <div>
      <h2 class="ml-5 mt-4">Tambah Kartu Keluarga</h2>
      <div class="mt-1 ml-4">
        <div class="d-flex flex-row">
          <div>
            <router-link
              to="/Home"
              tag="button"
              class="btn btn-primary mt-lg-4 ml-lg-4"
              >Back</router-link
            >
          </div>
        </div>
      </div>
    </div>
    <div class="mt-3 ml-5 mr-5">
      <form 
        id="tambah-kartu"
        @submit.prevent="inputKartu"
        v-show="!success"
       class="border border-info">
        <div class="d-flex flex-row">
          <div class="d-flex flex-column ml-5 mt-5 mb-5">
            <div class="form-group row">
              <label for="nomorkk" class="col-sm-6 col-form-label"
                >Nomor Kartu Keluarga</label
              >
              <div class="col-sm-6">
                <input
                  v-model="kartuData.nomor_kk"
                  type="text"
                  class="form-control"
                  id="nomorkk"
                  placeholder="Masukkan Nomor Kartu Keluarga"
                />
              </div>
            </div>
            <div class="form-group row">
              <label for="alamat" class="col-sm-6 col-form-label">Alamat</label>
              <div class="col-sm-6">
                <textarea
                  v-model="kartuData.alamat"
                  type="text"
                  class="form-control"
                  id="alamat"
                  placeholder="Masukkan Alamat"
                />
              </div>
            </div>
            <div class="form-group row">
              <label for="rt" class="col-sm-6 col-form-label">RT</label>
              <div class="col-sm-6">
                <input
                  v-model="kartuData.rt"
                  type="text"
                  class="form-control"
                  id="rt"
                  placeholder="Masukkan RT"
                />
              </div>
            </div>
            <div class="form-group row">
              <label for="rw" class="col-sm-6 col-form-label">RW</label>
              <div class="col-sm-6">
                <input
                  v-model="kartuData.rw"
                  type="text"
                  class="form-control"
                  id="rw"
                  placeholder="Masukkan RW"
                />
              </div>
            </div>
          </div>
          <div class="item-form">
            <div class="form-group row">
              <label for="desa" class="col-sm-6 col-form-label"
                >Desa / Kelurahan</label
              >
              <div class="col-sm-6">
                <input
                  v-model="kartuData.desa_kelurahan"
                  type="desa"
                  class="form-control"
                  id="inputEmail3"
                  placeholder="Masukkan Nama Desa"
                />
              </div>
            </div>
            <div class="form-group row">
              <label for="kecamatan" class="col-sm-6 col-form-label"
                >Kecamatan</label
              >
              <div class="col-sm-6">
                <input
                  v-model="kartuData.kecamatan"
                  type="text"
                  class="form-control"
                  id="kecamatan"
                  placeholder="Masukkan Nama Kecamatan"
                />
              </div>
            </div>
            <div class="form-group row">
              <label for="kabupaten" class="col-sm-6 col-form-label"
                >Kabupaten / Kota</label
              >
              <div class="col-sm-6">
                <input
                  v-model="kartuData.kabupaten_kota"
                  type="text"
                  class="form-control"
                  id="kabupaten"
                  placeholder="Masukkan Nama Kabupaten / Kota"
                />
              </div>
            </div>
            <div class="form-group row">
              <label for="provinsi" class="col-sm-6 col-form-label"
                >Provinsi</label
              >
              <div class="col-sm-6">
                <input
                  v-model="kartuData.provinsi"
                  type="text"
                  class="form-control"
                  id="provinsi"
                  placeholder="Masukkan Nama Provinsi"
                />
              </div>
            </div>
            <div class="form-group row">
              <label for="kodepos" class="col-sm-6 col-form-label"
                >Kode Pos</label
              >
              <div class="col-sm-6">
                <input
                  v-model="kartuData.kode_pos"
                  type="text"
                  class="form-control"
                  id="kodepos"
                  placeholder="Masukkan Kode Pos"
                />
              </div>
            </div>
          </div>
        </div>
        <div class="d-flex flex-row">
        <button class="btn btn-primary ml-5 mb-5" type="submit">
          Submit
        </button>
        <p v-show="checkNoKK" class="font-weight-bold ml-5" style="color: red;">Maaf Nomor Kartu Keluarga sudah terdaftar!</p>

        </div>
      </form>
      <KartuSuccessForm v-show="success"></KartuSuccessForm>
    </div>
  </div>
</template>

<script>
import kartuService from "../services/proService.js";
import KartuSuccessForm from "../components/KartuSuccessForm.vue";


export default {
  name: "FormtambahComp",
  components:{
    KartuSuccessForm,

  },

  data(){
    return{
      kartuData:{
        nomor_kk: null,
        alamat: null,
        rt: null,
        rw: null,
        desa_kelurahan: null,
        kecamatan: null,
        kabupaten_kota: null,
        provinsi: null,
        kode_pos: null,
      },
      success: false,
      buttonValue: "Submit",
      checkNoKK: false,
    };
  },

  methods:{
    inputKartu(){
      let data = this.kartuData;

      if(this.buttonValue == "Submit"){
        kartuService.create(data)
        .then((response) => {
          console.log(response.data)
          this.success = true;
        })
        .catch((e) =>{
          if(e.response.data.trace.includes("Duplicate entry")){
            this.checkNoKK = true
          }
        });
      }else{
        kartuService.updateKartu(data.id, data)
        .then((response) => {
          console.log(response.data);
          this.success = true;
        })
        .catch((e) => {
          console.log(e);
        });
      }
    },
  },

};
</script>


<style scoped>
.item-form {
  margin-left: 180px;
  margin-top: 40px;
}
</style>