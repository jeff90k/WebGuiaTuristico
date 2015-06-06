$(document).ready(function() {
	$('#fCadUsuario').bootstrapValidator({
		// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			nome: {
				message: 'Nome icorreto.',
				validators: {
					notEmpty: {
						message: 'Campo obrigatório.'
					},
					stringLength: {
						min: 2,
						max: 20,
						message: 'Nome deve conter no mínimo 2 e no máximo 20 caracteres.'
					}
				}
			},
			sobrenome: {
				message: 'Nome icorreto.',
				validators: {
					notEmpty: {
						message: 'Campo obrigatório.'
					},
					stringLength: {
						min: 2,
						max: 40,
						message: 'Nome deve conter no mínimo 2 e no máximo 40 caracteres.'
					}
				}
			},
			email: {
				message: 'Preencha o campo corretamente.',
				validators: {
					notEmpty: {
						message: 'Campo obrigatório.'
					},
					regexp: {
						regexp: /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/,
						message: 'Dica: email@dominio.com'
					}
				}
			},
			sexo: {
				message: 'Preencha o campo corretamente.',
				validators: {
					notEmpty: {
						message: 'Campo obrigatório.'
					}
				}
			},
			estado: {
				message: 'Preencha o campo corretamente.',
				validators: {
					notEmpty: {
						message: 'Campo obrigatório.'
					}
				}
			},
			cidade: {
				message: 'Preencha o campo corretamente.',
				validators: {
					notEmpty: {
						message: 'Campo obrigatório.'
					}
				}
			},
			data_nascimento: {
				message: 'Preencha o campo corretamente.',
				validators: {
					notEmpty: {
						message: 'Campo obrigatório.'
					},
					stringLength: {
						min: 10,
						max: 10,
						message: 'Nome deve conter no mínimo 2 e no máximo 40 caracteres.'
					}
				}
			},
			login: {
				message: 'Preencha o campo corretamente.',
				validators: {
					notEmpty: {
						message: 'Campo obrigatório.'
					},
					regexp: {
						regexp: /^[a-zA-Z0-9]+$/,
						message: 'O login não pode conter caracteres especiais.'
					}
				}
			},
			submitHandler: function (form) {
            $.ajax({
                type: $(form).attr('method'),
                url: "../php/client/json.php",
                data: $(form).serialize(),
                success: function (data, status) {
                    $(this).modal('hide');
                }
            });
            alert('valid form submitted by ajax'); // for demo
            return false;
        }

		}
	});
});