//app.js
App({
  onLaunch: function (parm) {
    console.log(parm)
    this.globalData.entery_scene = parm.scene
    this.globalData.vote_id = parm.query.vote_id
   },
  
  globalData: {
    userInfo: null,
    session_key: null,
    open_id: null,
    vote_id: null,
    entery_scene:null
  }
})