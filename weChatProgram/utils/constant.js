const request_url = {
  login: "user/weChatLogin",
  addNewVote:"voteinfo/addNewVote"
}

const golable_variable ={
  appid : "wxa89b0e1e9136faec",
  appsecret : "3b85c08f6c96607033e925e1c93a0705",
  getsession_url : "https://api.weixin.qq.com/sns/jscode2session"

}

const prev_url_dev = "http://localhost:8080/";
const prev_url_prd = "";

const getUrl_dev = url =>{
  return prev_url_dev + url;
}

const getUrl_prd = url =>{
  return prev_url_prd +url;
}

module.exports = {
  getUrl: getUrl_dev,
  request_url:request_url,
  golable_variable : golable_variable
}