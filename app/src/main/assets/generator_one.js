Blockly.JavaScript['stoplight'] = function(block) {
  var dropdown_lightcolor = block.getFieldValue('lightcolor');
  var dropdown_lightswitch = block.getFieldValue('lightswitch');
  // TODO: Assemble JavaScript into code variable.
  var code = dropdown_lightcolor + '\n';
  return code;
};

Blockly.JavaScript['start'] = function(block) {
  // TODO: Assemble JavaScript into code variable.
  var code = 'start\n';
  return code;
};

Blockly.JavaScript['move'] = function(block) {
  var number_name = block.getFieldValue('NAME');
  // TODO: Assemble JavaScript into code variable.
  var code = 'move\n';
  return code;
};
Blockly.JavaScript['moveup'] = function(block) {
  var number_name = block.getFieldValue('NAME');
  // TODO: Assemble JavaScript into code variable.
  var code = 'moveup\n';
  return code;
};
Blockly.JavaScript['movedown'] = function(block) {
  var number_name = block.getFieldValue('NAME');
  // TODO: Assemble JavaScript into code variable.
  var code = 'movedown\n';
  return code;
};
Blockly.JavaScript['moveleft'] = function(block) {
  var number_name = block.getFieldValue('NAME');
  // TODO: Assemble JavaScript into code variable.
  var code = 'moveleft\n';
  return code;
};
Blockly.JavaScript['moveright'] = function(block) {
  var number_name = block.getFieldValue('NAME');
  // TODO: Assemble JavaScript into code variable.
  var code = 'moveright\n';
  return code;
};
Blockly.JavaScript['foreverloop'] = function(block) {
  var statements_name = Blockly.JavaScript.statementToCode(block, 'NAME');
  // TODO: Assemble JavaScript into code variable.
  var code = 'foreverloop\n';
  return code;
};
Blockly.JavaScript['forloop'] = function(block) {
  var number_name = block.getFieldValue('NAME');
  var statements_forloop = Blockly.JavaScript.statementToCode(block, 'forloop');
  // TODO: Assemble JavaScript into code variable.
  var code = 'forloop;\n';
  return code;
};
Blockly.JavaScript['repeat'] = function(block) {
  var number_name = block.getFieldValue('NAME');
  var statements_repeat = Blockly.JavaScript.statementToCode(block, 'repeat');
  // TODO: Assemble JavaScript into code variable.
  var code = 'repeat\n';
  return code;
  };

Blockly.JavaScript['turn_angles'] = function(block) {
  var angle_90 = block.getFieldValue('90');
  // TODO: Assemble JavaScript into code variable.
  var code = 'turn_angles\n';
  return code;
};