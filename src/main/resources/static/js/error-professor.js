(() => {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  const forms = document.querySelectorAll('.needs-validation')

  // Function to display alerts
  const alertPlaceholder = document.getElementById('liveAlertPlaceholder')
  const appendAlert = (message, type) => {
    const wrapper = document.createElement('div')
    wrapper.innerHTML = [
      `<div class="alert alert-${type} alert-dismissible" role="alert">`,
      `   <div>${message}</div>`,
      '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
      '</div>'
    ].join('')

    alertPlaceholder.append(wrapper)
  }

  // Loop over them and handle submission
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      event.preventDefault()
      event.stopPropagation()

      if (!form.checkValidity()) {
        form.classList.add('was-validated')
      } else {
        // Form is valid, submit data via AJAX
        form.classList.add('was-validated')

        // Collect form data
        const formData = new FormData(form)

        // Send data using fetch API
        fetch(form.action, {
          method: form.method,
          body: formData,
        })
        .then(response => {
          if (response.ok) {
            appendAlert('Professor criado com sucesso!', 'success')
          } else {
            appendAlert('Houve um problema ao criar um novo professor. Verifique se o e-mail ou telefone já está em uso.', 'danger')
          }
        })
        .catch(error => {
          console.error('Error:', error)
          appendAlert('Houve um problema no envio do formulário.', 'danger')
        })
      }
    }, false)
  })
})()