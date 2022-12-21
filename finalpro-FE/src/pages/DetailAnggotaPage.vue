.<template>
  <div>
    <div class="dashboard">
      <SidebarComp></SidebarComp>
      <div class="content">
        <DetailAnggota></DetailAnggota>
      </div>
    </div>
  </div>
</template>

<script>
import DetailAnggota from "../components/DetailAnggotaComp.vue"
import SidebarComp from "../components/layout/SidebarComp.vue"

export default {
    name: "DetailAnggotaPage",
    components: {
        DetailAnggota,
        SidebarComp,
    }

}
</script>

<style scoped>
.dashboard {
  display: grid;
  grid-template-columns: 1fr 5fr;
  background-color: teal;
  height: 100vh;
  width: 100vw;
}

.content {
  background-color: white;
  border-radius: 20px;
  margin-top: 15px;
  margin-right: 10px;
}

</style>