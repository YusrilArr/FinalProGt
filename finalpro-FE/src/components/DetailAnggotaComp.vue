.<template>
  <div>
  
      <h2 class="ml-5">Update Anggote Keluarga</h2>
      <div v-show="!success">
        <div>
          <div class="mt-1 ml-4">
            <div class="d-flex flex-row">
              <div>
                <button class="btn btn-primary mt-4 ml-3" @click="$router.back()">Back</button>
              </div>

              <div>
                <button
                  v-show="!update"
                  @click="updateButton"
                  type="submit"
                  class="btn btn-success mt-lg-4 ml-lg-4"
                >
                  Update Anggota Keluarga
                </button>
                
              </div>
            </div>
          </div>
        </div>
        <div>
          <form class="ml-5 mt-3 mr-5" @submit.prevent="updateAnggota" >
            <div class="d-flex flex-row border border-info">
              <div class="d-flex flex-column ml-5 mt-5 mb-5">
                <div class="form-group row">
                  <label for="nomorkk" class="col-sm-6 col-form-label"
                    >NIK</label
                  >
                  <div class="col-sm-6">
                    <input
                      v-model="anggotaData.nik"
                      type="text"
                      class="form-control"
                      id="nik"
                      name="nik"
                      placeholder="NIK"
                      :disabled="isDisabled"
                    />
                  </div>
                </div>
                <div class="form-group row">
                  <label for="nama" class="col-sm-6 col-form-label">Nama</label>
                  <div class="col-sm-6">
                    <input
                      v-model="anggotaData.nama"
                      type="text"
                      class="form-control"
                      id="nama"
                      name="nama"
                      placeholder="Nama"
                      :disabled="isDisabled"
                    />
                  </div>
                </div>
                <div class="form-group row">
                  <label for="jenis_kelamin" class="col-sm-6 col-form-label">Jenis Kelamin</label>
                  <div class="col-sm-6">
                    <input
                      v-model="anggotaData.jenis_kelamin"
                      type="text"
                      class="form-control"
                      id="jenis_kelamin"
                      name="jenis_kelamin"
                      placeholder="Jenis Kelamin"
                      :disabled="isDisabled"
                    />
                  </div>
                </div>
                <div class="form-group row">
                  <label for="tempat_lahir" class="col-sm-6 col-form-label">Tempat Lahir</label>
                  <div class="col-sm-6">
                    <input
                      v-model="anggotaData.tempat_lahir"
                      type="text"
                      class="form-control"
                      id="tempat_lahir"
                      name="tempat_lahir"
                      placeholder="Tempat Lahir"
                      :disabled="isDisabled"
                    />
                  </div>
                </div>
              </div>
              <div class="item-form">
                <div class="form-group row">
                  <label for="tanggal_lahir" class="col-sm-6 col-form-label"
                    >Tanggal Lahir</label
                  >
                  <div class="col-sm-6">
                    <input
                      v-model="anggotaData.tanggal_lahir"
                      type="text"
                      class="form-control"
                      id="tanggal_lahir"
                      name="tanggal_lahir"
                      placeholder="Tanggal Lahir"
                      :disabled="isDisabled"
                    />
                  </div>
                </div>
                <div class="form-group row">
                  <label for="agama" class="col-sm-6 col-form-label"
                    >Agama</label
                  >
                  <div class="col-sm-6">
                    <input
                      v-model="anggotaData.agama"
                      type="text"
                      class="form-control"
                      id="agama"
                      name="agama"
                      placeholder="Agama"
                      :disabled="isDisabled"
                    />
                  </div>
                </div>
                <div class="form-group row">
                  <label for="pendidikan" class="col-sm-6 col-form-label"
                    >Pendidikan Terakhir</label
                  >
                  <div class="col-sm-6">
                    <input
                      v-model="anggotaData.pendidikan"
                      type="text"
                      class="form-control"
                      id="pendidikan"
                      name="pendidikan"
                      placeholder="Pendidikan Terakhir"
                      :disabled="isDisabled"
                    />
                  </div>
                </div>
                <div class="form-group row">
                  <label for="kepala_keluarga" class="col-sm-6 col-form-label"
                    >Kepala Keluarga</label
                  >
                  <div class="col-sm-6">
                    <input
                      v-model="anggotaData.kepala_keluarga"
                      type="text"
                      class="form-control"
                      id="kepala_keluarga"
                      name="kepala_keluarga"
                      placeholder="Kepala Keluarga"
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
                    @click.prevent="updateAnggota"
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
import anggotaService from "../services/proService.js";
import UpdateSuccessForm from "../components/UpdateSuccessForm.vue";

export default {
  name: "DetailkkComp",
  components:{
    UpdateSuccessForm,

  },
  
  data(){
    return{
      anggotaData:{
        nik: null,
        agama: null,
        nama: null,
        jenis_kelamin: null,
        tempat_lahir: null,
        tanggal_lahir: null,
        pendidikan: null,
        kepala_keluarga: null,
      },
      success: false,
      update: false,
      isDisabled: true,
    }
  },

  methods:{
    getAnggotaById(){
      let id = this.$route.params.idAnggota;
      anggotaService.getAnggotaById(id)
      .then((response) => {
        this.anggotaData = response.data;
        console.log(this.anggotaData);

      })
      .catch((e) => {
        console.log(e);
      })
    },

    updateAnggota(){
      let data = this.anggotaData;
      let id = this.$route.params.idAnggota;
      anggotaService.updateAnggota(id, data)
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
      this.getAnggotaById();
    }

};
</script>

<style scoped>
.item-form {
  margin-left: 180px;
  margin-top: 40px;
}
</style>