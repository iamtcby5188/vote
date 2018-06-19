//index.js
//获取应用实例
const app = getApp()
const constant = require("../../utils/constant.js")
Page({
  data: {
    showLoading:true,
    showButton:false,
    finishdata:false,
    loadingtext:"正在登录",
    mutil_selection: {
      model: 'aspectFit',
      src: "../../resources/vote_index/mutil_selection.jpg"
    },
    single_selection: {
      model: 'aspectFit',
      src: "../../resources/vote_index/single_selection.jpg"
    }
  },
  onLoad: function (options) {
    // 登录
    wx.login({
      success: res => {
        this.login_success(res);
      },
      fail: function (res) {
        console.log("login failed");
      }
    })
  },
  onReady: function () {
    // 页面渲染完成
  },
  onShow: function () {
    // 页面显示
  },
  onHide: function () {
    // 页面隐藏
  },
  onUnload: function () {
    // 页面关闭
  },
  get_user_info:function(){
    this.setData({ loadingtext:"正在获取用户信息"})
    wx.getUserInfo({
      success : res=>{
        app.globalData.userInfo = res.userInfo;
        this.login_service()
      },
      fail : res=>{
        console.log(res);
      }
    })
  },
  login_success: function (res){
    wx.request({
      url: constant.golable_variable.getsession_url,
      data: {
        appid: constant.golable_variable.appid,
        secret: constant.golable_variable.appsecret,
        js_code: res.code,
        grant_type: "authorization_code"
      },
      success: res=> {
        // 获取用户信息
        app.globalData.session_key = res.data.session_key
        app.globalData.open_id = res.data.openid
        this.get_session_success()
      },
      fail: res=> {
        console.log("get session failed");
      }
    })
  },
  get_session_success:function(){
    wx.getSetting({
      success: set_res => {
        if (set_res.authSetting["scope.userInfo"]) {
          this.get_user_info();
        }
        else {
          this.setData({
            showLoading : false,
            showButton:true})
        }
      }
    })
  },
  onGotUserInfo: function (e) {
    app.globalData.userInfo = e.detail.userInfo
    this.login_service()
  },
  login_service:function(){
    console.log(app.globalData.userInfo);
    console.log(app.globalData.userInfo.avatarUrl);
    wx.request({
      url: constant.getUrl(constant.request_url.login),
      data: {
        nickname: app.globalData.userInfo.nickName,
        gender: app.globalData.userInfo.gender,
        country: app.globalData.userInfo.country,
        province: app.globalData.userInfo.province,
        city: app.globalData.userInfo.city,
        avatar_url: app.globalData.userInfo.avatarUrl,
        open_id: app.globalData.open_id,
        session_key: app.globalData.session_key,
      },
      method:'POST',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: res => {
        console.log(res);
        app.globalData.userInfo.id = res.data.id;
        console.log(app.globalData.userInfo)
        this.redirectWindow()
      },
      fail: res => {
        console.log("longin_service failed");
      }
    })
  },
  redirectWindow:function(){
    //this.setData({finishdata:true})
    wx.navigateTo({
      url: '../user_vote/user_vote?vote_id=beefa398872c4438a46b40cee7ed4b5f',
    })
  },
  clickMutilImage: function () {
    console.log("click mutilImage")
    wx.navigateTo({
      url: '../vote/vote?type=' + constant.golable_variable.vote_mutil
    })
  },
  clickSingleImage: function () {
    console.log("click singleImgae")
    wx.navigateTo({
      url: '../vote/vote?type=' + constant.golable_variable.vote_single
    })
  }
})
