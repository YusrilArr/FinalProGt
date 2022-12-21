.<template>
  <div class="sidebar">
    <div class="title">E-KTP App</div>
    <div class="menu-items">
      <router-link
        to="/Home"
        active-class="active"
        exact
        tag="button"
        class="side-btn"
      >
        <div class="link-container">Home</div>
      </router-link>

      <router-link
        to="/Tambah"
        active-class="active"
        exact
        tag="button"
        class="side-btn"
      >
        <div class="link-container">Tambah KK</div>
      </router-link>

      <router-link
        to="/Login"
        active-class="active"
        tag="button"
        class="side-btn"
      >
        <div class="link-container">Sign Out</div>
      </router-link>
    </div>

    \
  </div>
</template>

<script>
export default {
  name: "SidebarComp",
};
</script>

<style scoped>
.title {
  margin-top: 20px;
  color: black;
  font-weight: bold;
  font-size: 40px;
  text-align: center;
}
.menu-items {
  display: flex;
  flex-direction: column;
  margin-top: 25px;
}

.menu-items > * {
  margin-top: 40px;
}

.side-btn:focus {
  outline: none;
}

.side-btn.active {
  position: relative;
  background-color: white;
  color: teal;
  font-weight: 500;
}

.side-btn.active::before {
  position: absolute;
  content: "";
  top: -30px;
  right: 0;
  height: 30px;
  width: 30px;
  background-color: white;
}
.side-btn.active::after {
  position: absolute;
  content: "";
  bottom: -30px;
  right: 0;
  height: 30px;
  width: 30px;
  background-color: white;
}

.side-btn {
  border: none;
  padding: 20px 0px;
  cursor: pointer;
  font-size: 15px;
  font-weight: bold;
  color: white;
  background-color: transparent;
}

.side-btn.active .link-container::before {
  position: absolute;
  top: -60px;
  right: 0;
  content: "";
  height: 60px;
  width: 60px;
  border-radius: 50%;
  background-color: teal;
}

.side-btn.active .link-container::after {
  position: absolute;
  bottom: -60px;
  right: 0;
  content: "";
  height: 60px;
  width: 60px;
  border-radius: 50%;
  background-color: teal;
  z-index: 99;
}
</style>