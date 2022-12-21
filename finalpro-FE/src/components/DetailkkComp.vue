.<template>
  <div>
  
      <h2 class="ml-5">Detail Kartu Keluarga</h2>
      <div v-show="!success">
        <div>
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

              <div>
                <button
                  v-show="!update"
                  @click="updateButton"
                  type="submit"
                  class="btn btn-success mt-lg-4 ml-lg-4"
                >
                  Update Kartu Keluarga
                </button>
                
              </div>
              <div>
                <router-link
                  :to="{ name: 'ListPage'}">
                  <button class="btn btn-info mt-4 ml-4" type="button">
                  Lihat Anggota Keluarga

                  </button>
                  </router-link>
              </div>
            </div>
          </div>
        </div>
        <div>
          <form class="ml-5 mt-3 mr-5" @submit.prevent="updateKartu" >
            <div class="d-flex flex-row border border-info">
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
                      id="nomor_kk"
                      name="nomor_kk"
                      placeholder="Nomor KK"
                      :disabled="isDisabled"
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
                      name="alamat"
                      placeholder="Alamat"
                      :disabled="isDisabled"
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
                      name="rt"
                      placeholder="RT"
                      :disabled="isDisabled"
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
                      name="rw"
                      placeholder="RW"
                      :disabled="isDisabled"
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
                      id="desa_kelurahan"
                      name="desa_kelurahan"
                      placeholder="Desa / Kelurahan"
                      :disabled="isDisabled"
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
                      name="kecamatan"
                      placeholder="Kecamatan"
                      :disabled="isDisabled"
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
                      id="kabupaten_kota"
                      name="kabupaten_kota"
                      placeholder="Kabupaten / Kota"
                      :disabled="isDisabled"
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
                      name="provinsi"
                      placeholder="Provinsi"
                      :disabled="isDisabled"
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
                      id="kode_pos"
                      name="kode_pos"
                      placeholder="Kode Pos"
                      :disabled="isDisabled"
                    />
                  </div>
                </div>
              </div>
            </div>
            <div class="button-update" v-show="update">
                  <button
                    type="submit"
                    class="btn btn-danger mt-5 mr-2"
                    @click.prevent="cancelUpdate"
                  >
                    Cancel
                  </button>
                  <button
                    type="submit"
                    class="btn btn-success mt-5"
                    @click.prevent="updateKartu"
                  >
                    Update
                  </button>
                </div>
          </form>
        </div>

      </div>
          <UpdateSuccessForm v-show="success"></UpdateSuccessForm>

  </div>
</template>

<script>
import kartuService from "../services/proService.js";
import UpdateSuccessForm from "../components/UpdateSuccessForm.vue";

export default {
  name: "DetailkkComp",
  components:{
    UpdateSuccessForm,

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
      update: false,
      isDisabled: true,
    }
  },

  methods:{
    getKK(){
      let id = this.$route.params.id;
      kartuService.getKK(id)
      .then((response) => {
        this.kartuData = response.data;
        console.log(this.kartuData);

      })
      .catch((e) => {
        console.log(e);
      })
    },

    updateKartu(){
      let data = this.kartuData;
      let id = this.$route.params.id;
      kartuService.updateKartu(id, data)
      .then((response) =>{
        console.log(response.data);
        this.success = true;
      })
      .catch((e) =>{
        console.log(e);
      });
    },

    updateButton(){
      this.update = true;
      this.isDisabled = false;
    },

    cancelUpdate(){
      location.reload();
    },

      
  },
    mounted(){
      this.getKK();
    }

};
</script>

<style scoped>
.item-form {
  margin-left: 180px;
  margin-top: 40px;
}
</style>