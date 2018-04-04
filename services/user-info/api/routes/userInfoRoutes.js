'use strict';
module.exports = function(app) {
  var controller = require('../controllers/userInfoController');

  app.route('/user-info/:userId')
    .get(controller.get_user_info);
};
